/**
 * 
 */
package flight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flight.dto.SyntheseCompanyDto;
import flight.models.Flight;
import flight.models.FlightCriteria;
import flight.models.SynthesisCriteria;
import flight.repository.FlightRepository;
import flight.service.FlightService;

/**
 * @author Emanuele Cancelli
 *
 */
@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public Flight addFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@Override
	public List<Flight> searchFlight(FlightCriteria flightCriteria) {
		return flightRepository.searchFlight(flightCriteria);
	}

	@Override
	public Flight getFlight(Long idFlight) {
		return flightRepository.findById(idFlight).orElse(null);
	}

	@Override
	public Long getNumberFlights(SynthesisCriteria synthesisCriteria) {
		return flightRepository.getNumberFlights(synthesisCriteria);
	}

	@Override
	public List<SyntheseCompanyDto> getNbsFlightsByCompany(SynthesisCriteria synthesisCriteria) {
		return flightRepository.getNbsFlightsByCompany(synthesisCriteria);
	}
}
