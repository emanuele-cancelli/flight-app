/**
 * 
 */
package flight.dto;

import java.time.LocalDate;

import flight.models.Account;
import flight.models.FlightCriteria;

/**
 * @author Emanuele Cancelli
 *
 */
public class BookmarkResponseDto {
	private Long idBookmark;
	private String title;
	private LocalDate addingDate;
	private int nbFlights;
	private FlightCriteria flightCriteria;
	private Account account;
	
	/**
	 * @return the idBookmark
	 */
	public Long getIdBookmark() {
		return idBookmark;
	}

	/**
	 * @param idBookmark the idBookmark to set
	 */
	public void setIdBookmark(Long idBookmark) {
		this.idBookmark = idBookmark;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the addingDate
	 */
	public LocalDate getAddingDate() {
		return addingDate;
	}

	/**
	 * @param addingDate the addingDate to set
	 */
	public void setAddingDate(LocalDate addingDate) {
		this.addingDate = addingDate;
	}

	/**
	 * @return the nbFlights
	 */
	public int getNbFlights() {
		return nbFlights;
	}

	/**
	 * @param nbFlights the nbFlights to set
	 */
	public void setNbFlights(int nbFlights) {
		this.nbFlights = nbFlights;
	}

	/**
	 * @return the flightCriteria
	 */
	public FlightCriteria getFlightCriteria() {
		return flightCriteria;
	}

	/**
	 * @param flightCriteria the flightCriteria to set
	 */
	public void setFlightCriteria(FlightCriteria flightCriteria) {
		this.flightCriteria = flightCriteria;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @param idBookmark
	 * @param title
	 * @param addingDate
	 * @param nbFlights
	 * @param flightCriteria
	 * @param account
	 */
	public BookmarkResponseDto(Long idBookmark, String title, LocalDate addingDate, int nbFlights,
			FlightCriteria flightCriteria, Account account) {
		super();
		this.idBookmark = idBookmark;
		this.title = title;
		this.addingDate = addingDate;
		this.nbFlights = nbFlights;
		this.flightCriteria = flightCriteria;
		this.account = account;
	}

	/**
	 * 
	 */
	public BookmarkResponseDto() {
		super();
	}

}
