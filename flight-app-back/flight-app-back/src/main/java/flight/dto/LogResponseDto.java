/**
 * 
 */
package flight.dto;

/**
 * @author Emanuele Cancelli
 *
 */
public class LogResponseDto {
	
	String jwt;

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param jwt the jwt to set
	 */
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	/**
	 * @param jwt
	 */
	public LogResponseDto(String jwt) {
		super();
		this.jwt = jwt;
	}

	/**
	 * 
	 */
	public LogResponseDto() {
		super();
	}
}
