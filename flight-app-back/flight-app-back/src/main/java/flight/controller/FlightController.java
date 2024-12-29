/**
 * 
 */
package flight.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import flight.dto.AccountDto;
import flight.dto.FlightDto;
import flight.dto.LogResponseDto;
import flight.dto.LoginDto;
import flight.dto.SyntheseCompanyDto;
import flight.models.Account;
import flight.models.Flight;
import flight.models.FlightCriteria;
import flight.models.SynthesisCriteria;
import flight.service.AccountService;
import flight.service.FlightService;
import flight.util.JwtTokenUtil;

/**
 * @author Emanuele Cancelli
 *
 */
@RestController
@RequestMapping("flight-webservices/api/v1.0/flights")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	ModelMapper modelMapper;
	
	// added to modelMapper in the constructor
	PropertyMap<Flight, FlightDto> companyFieldMapping = new PropertyMap<Flight, FlightDto>() {
		@Override
		protected void configure() {
			map().setCompanyName(source.getCompany().getCompanyName());	
			map().setCabinDetails(source.getCompany().getCabinDetails());	
			map().setInflightInfo(source.getCompany().getInflightInfo());			
		}	
	};
	
	// modelMapper instance comes from the FlightApplication class
	@Autowired
	public FlightController(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		this.modelMapper.addMappings(companyFieldMapping);
	}
	
	@PostMapping("/addFlight")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		Flight addedFlight = flightService.addFlight(flight);
		return new ResponseEntity<Flight>(addedFlight, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/allFlights")
	public ResponseEntity<List<FlightDto>> getAllFlights() {
		List<FlightDto> flights = flightService.getAllFlights().stream()
				.map(flight -> modelMapper.map(flight, FlightDto.class))
				.collect(Collectors.toList());
		return new ResponseEntity<List<FlightDto>>(flights, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<FlightDto>> searchFlights(@RequestBody FlightCriteria flightCriteria) {
		List<FlightDto> flights = flightService.searchFlight(flightCriteria).stream()
				.map(flight -> modelMapper.map(flight, FlightDto.class))
				.collect(Collectors.toList());
		return new ResponseEntity<List<FlightDto>>(flights, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/getFlight/{id}")
	public ResponseEntity<FlightDto> getFlight(@PathVariable(value = "id") Long idFlight) {
		Flight flight = flightService.getFlight(idFlight);
		FlightDto flightDto = modelMapper.map(flight, FlightDto.class); 
		return new ResponseEntity<FlightDto>(flightDto, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/numberFlights")
	public ResponseEntity<Long> getNumberFlights(@RequestBody SynthesisCriteria synthesisCriteria) {
		Long nbFlights = flightService.getNumberFlights(synthesisCriteria);
		return new ResponseEntity<Long>(nbFlights, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/syntheseCompany")
	public ResponseEntity<List<SyntheseCompanyDto>> getNbsFlightsByCompany(@RequestBody SynthesisCriteria synthesisCriteria) {
		List<SyntheseCompanyDto> syntheseCompanyDtos = flightService.getNbsFlightsByCompany(synthesisCriteria);
		return new ResponseEntity<List<SyntheseCompanyDto>>(syntheseCompanyDtos, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Account> addAccount(@Valid @RequestBody AccountDto accountDto) {
		Account addedAccount = accountService.addAccount(accountDto);
		return new ResponseEntity<Account>(addedAccount, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<LogResponseDto> authenticate(@RequestBody LoginDto loginDto) throws Exception {
		try {
			// authenticate method calls loadUserByUsername and checks password with the one returned in userDetails
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		UserDetails userDetails = accountService.loadUserByUsername(loginDto.getUsername());
		String jwt = jwtTokenUtil.generateJwt(userDetails);
		return new ResponseEntity<LogResponseDto>(new LogResponseDto(jwt), new HttpHeaders(), HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException exception) {
		Map<String, String> errors = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String field = "";
			if(error.getClass().getSimpleName().equals("ViolationObjectError")) {
				field = ((ObjectError)error).getObjectName();
			}
			else if(error.getClass().getSimpleName().equals("ViolationFieldError")) {
				field = ((FieldError)error).getField();
			}
			String message = error.getDefaultMessage();
			errors.put(field, message);
		 });
		return errors;	
	}
}
