/**
 * 
 */
package flight.dto;

import flight.models.FlightCriteria;

/**
 * @author Emanuele Cancelli
 *
 */
public class BookmarkDto {

	private String title;
	private int nbFlights;
	private FlightCriteria flightCriteria;
	
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
	 * @param title
	 * @param nbFlights
	 * @param flightCriteria
	 */
	public BookmarkDto(String title, int nbFlights, FlightCriteria flightCriteria) {
		super();
		this.title = title;
		this.nbFlights = nbFlights;
		this.flightCriteria = flightCriteria;
	}

	/**
	 * 
	 */
	public BookmarkDto() {
		super();
	}

}
