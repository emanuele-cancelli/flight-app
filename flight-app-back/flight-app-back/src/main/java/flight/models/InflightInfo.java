/**
 * 
 */
package flight.models;

import javax.persistence.Embeddable;

/**
 * @author Emanuele Cancelli
 *
 */
@Embeddable
public class InflightInfo {

	String title;
	
	String description;

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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param title
	 * @param description
	 */
	public InflightInfo(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	/**
	 * 
	 */
	public InflightInfo() {
		super();
	}
	
}
