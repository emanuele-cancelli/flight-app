/**
 * 
 */
package flight.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flight.dto.AccountDto;
import flight.dto.FlightDto;
import flight.dto.SyntheseCompanyDto;
import flight.models.Account;
import flight.models.Flight;
import flight.models.FlightCriteria;
import flight.models.SynthesisCriteria;
import flight.service.AccountService;
import flight.service.FlightService;

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
	public ResponseEntity<Account> addAccount(@RequestBody AccountDto accountDto) {
		Account addedAccount = accountService.addAccount(accountDto);
		return new ResponseEntity<Account>(addedAccount, new HttpHeaders(), HttpStatus.OK);
	}
}
