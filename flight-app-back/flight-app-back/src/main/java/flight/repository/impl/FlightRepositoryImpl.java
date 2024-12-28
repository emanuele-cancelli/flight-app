/**
 * 
 */
package flight.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import flight.dto.SyntheseCompanyDto;
import flight.enumerations.CompanyName;
import flight.models.Flight;
import flight.models.FlightCriteria;
import flight.models.SynthesisCriteria;
import flight.repository.FlightRepositoryCustom;

/**
 * @author Emanuele Cancelli
 *
 */
public class FlightRepositoryImpl implements FlightRepositoryCustom{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Flight> searchFlight(FlightCriteria flightCriteria) {
		CriteriaBuilder cbuild = entityManager.getCriteriaBuilder();
		// specify the return type
		CriteriaQuery<Flight> cquery = cbuild.createQuery(Flight.class);
		// root is the entity type in the from clause
		Root<Flight> flight = cquery.from(Flight.class);
		// predicates are where conditions
		List<Predicate> predicates = new ArrayList<>();
		
		if(null!=flightCriteria.getCompany()) {
			predicates.add(cbuild.equal(flight.get("company").get("companyName"), flightCriteria.getCompany()));
		}
		if(null!=flightCriteria.getFlightType()) {
			predicates.add(cbuild.equal(flight.get("flightType"), flightCriteria.getFlightType()));
		}
		if(null!=flightCriteria.getTravelType()) {
			predicates.add(cbuild.equal(flight.get("travelType"), flightCriteria.getTravelType()));
		}
		if(null!=flightCriteria.getDepartureLocation()) {
			predicates.add(cbuild.like(flight.get("departureLocation"), "%" + flightCriteria.getDepartureLocation() + "%"));
		}
		if(null!=flightCriteria.getArrivalLocation()) {
			predicates.add(cbuild.like(flight.get("arrivalLocation"), "%" + flightCriteria.getArrivalLocation() + "%"));
		}
		if(null!=flightCriteria.getAircraftType()) {
			predicates.add(cbuild.like(flight.get("aircraftType"), "%" + flightCriteria.getAircraftType() + "%"));
		}
		if(null!=flightCriteria.getDepartureDateMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("departureDate"), flightCriteria.getDepartureDateMax()));
		}
		if(null!=flightCriteria.getDepartureDateMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("departureDate"), flightCriteria.getDepartureDateMin()));
		}
		if(null!=flightCriteria.getDepartureTimeMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("departureTime"), flightCriteria.getDepartureTimeMax()));
		}
		if(null!=flightCriteria.getDepartureTimeMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("departureTime"), flightCriteria.getDepartureTimeMin()));
		}		
		if(null!=flightCriteria.getArrivalDateMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("arrivalDate"), flightCriteria.getArrivalDateMax()));
		}
		if(null!=flightCriteria.getArrivalDateMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("arrivalDate"), flightCriteria.getArrivalDateMin()));
		}
		if(null!=flightCriteria.getArrivalTimeMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("arrivalTime"), flightCriteria.getArrivalTimeMax()));
		}
		if(null!=flightCriteria.getArrivalTimeMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("arrivalTime"), flightCriteria.getArrivalTimeMin()));
		}
		if(null!=flightCriteria.getBackDateMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("backDate"), flightCriteria.getBackDateMax()));
		}
		if(null!=flightCriteria.getBackDateMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("backDate"), flightCriteria.getBackDateMin()));
		}
		if(null!=flightCriteria.getBackTimeMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("backTime"), flightCriteria.getBackTimeMax()));
		}
		if(null!=flightCriteria.getBackTimeMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("backTime"), flightCriteria.getBackTimeMin()));
		}
		if(null!=flightCriteria.getConnectionDurationMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("connectionDuration"), flightCriteria.getConnectionDurationMax()));
		}
		if(null!=flightCriteria.getConnectionDurationMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("connectionDuration"), flightCriteria.getConnectionDurationMin()));
		}
		if(null!=flightCriteria.getFlightDurationMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("flightDuration"), flightCriteria.getFlightDurationMax()));
		}
		if(null!=flightCriteria.getFlightDurationMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("flightDuration"), flightCriteria.getFlightDurationMin()));
		}
		
		cquery.where(predicates.toArray(new Predicate[0]));
		return entityManager.createQuery(cquery).getResultList();
	}

	@Override
	public Long getNumberFlights(SynthesisCriteria synthesisCriteria) {
		CriteriaBuilder cbuild = entityManager.getCriteriaBuilder();
		// specify the return type
		CriteriaQuery<Long> cquery = cbuild.createQuery(Long.class);
		// root is the entity type in the from clause
		Root<Flight> flight = cquery.from(Flight.class);
		// select clause with count
		cquery.select(cbuild.count(flight));
		// predicates are where conditions
		List<Predicate> predicates = new ArrayList<>();
		if(null!=synthesisCriteria.getDepartureDateMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("departureDate"), synthesisCriteria.getDepartureDateMax()));
		}
		if(null!=synthesisCriteria.getDepartureDateMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("departureDate"), synthesisCriteria.getDepartureDateMin()));
		}
		cquery.where(predicates.toArray(new Predicate[0]));
		return entityManager.createQuery(cquery).getSingleResult();
	}

	@Override
	public List<SyntheseCompanyDto> getNbsFlightsByCompany(SynthesisCriteria synthesisCriteria) {
		CriteriaBuilder cbuild = entityManager.getCriteriaBuilder();
		// specify the return type
		CriteriaQuery<SyntheseCompanyDto> cquery = cbuild.createQuery(SyntheseCompanyDto.class);
		// root is the entity type in the from clause
		Root<Flight> flight = cquery.from(Flight.class);
		// expression for companyName, it will be used in count, select and groupBy clauses
		Expression<CompanyName> groupByExp = flight.get("company").get("companyName").as(CompanyName.class);
		// expression for count
		Expression<Long> countExp = cbuild.count(groupByExp);
		// select clause with more than one parameter
		cquery.multiselect(groupByExp, countExp);
		// group by clause
		cquery.groupBy(groupByExp);
		// predicates are where conditions
		List<Predicate> predicates = new ArrayList<>();
		if(null!=synthesisCriteria.getDepartureDateMax()) {
			predicates.add(cbuild.lessThanOrEqualTo(flight.get("departureDate"), synthesisCriteria.getDepartureDateMax()));
		}
		if(null!=synthesisCriteria.getDepartureDateMin()) {
			predicates.add(cbuild.greaterThanOrEqualTo(flight.get("departureDate"), synthesisCriteria.getDepartureDateMin()));
		}
		cquery.where(predicates.toArray(new Predicate[0]));
		return entityManager.createQuery(cquery).getResultList();
	}

}
