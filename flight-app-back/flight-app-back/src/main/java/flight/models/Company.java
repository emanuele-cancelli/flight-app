/**
 * 
 */
package flight.models;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import flight.enumerations.CompanyName;

/**
 * @author Emanuele Cancelli
 *
 */
@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCompany;

	@Column(name = "company_name")
	@Enumerated(EnumType.STRING)
	private CompanyName companyName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private Set<Flight> flights;
	
	@ElementCollection
	@CollectionTable(name = "cabin_details", joinColumns = @JoinColumn(name = "company_id"))
	private Set<CabinDetail> cabinDetails;
	
	@ElementCollection
	@CollectionTable(name = "inflight_infos", joinColumns = @JoinColumn(name = "company_id"))	
	private Set<InflightInfo> inflightInfo;

	/**
	 * @return the idCompany
	 */
	public int getIdCompany() {
		return idCompany;
	}

	/**
	 * @param idCompany the idCompany to set
	 */
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	/**
	 * @return the companyName
	 */
	public CompanyName getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(CompanyName companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the flights
	 */
	public Set<Flight> getFlights() {
		return flights;
	}

	/**
	 * @param flights the flights to set
	 */
	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	/**
	 * @return the cabinDetails
	 */
	public Set<CabinDetail> getCabinDetails() {
		return cabinDetails;
	}

	/**
	 * @param cabinDetails the cabinDetails to set
	 */
	public void setCabinDetails(Set<CabinDetail> cabinDetails) {
		this.cabinDetails = cabinDetails;
	}

	/**
	 * @return the inflightInfo
	 */
	public Set<InflightInfo> getInflightInfo() {
		return inflightInfo;
	}

	/**
	 * @param inflightInfo the inflightInfo to set
	 */
	public void setInflightInfo(Set<InflightInfo> inflightInfo) {
		this.inflightInfo = inflightInfo;
	}

	/**
	 * @param idCompany
	 * @param companyName
	 * @param flights
	 * @param cabinDetails
	 * @param inflightInfo
	 */
	public Company(int idCompany, CompanyName companyName, Set<Flight> flights, Set<CabinDetail> cabinDetails,
			Set<InflightInfo> inflightInfo) {
		super();
		this.idCompany = idCompany;
		this.companyName = companyName;
		this.flights = flights;
		this.cabinDetails = cabinDetails;
		this.inflightInfo = inflightInfo;
	}

	/**
	 * 
	 */
	public Company() {
		super();
	}
}
