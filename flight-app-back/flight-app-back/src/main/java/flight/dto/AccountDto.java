/**
 * 
 */
package flight.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import flight.validation.Password;
import flight.validation.PasswordMatches;

/**
 * @author Emanuele Cancelli
 *
 */
@PasswordMatches // custom validation for confpassword = password
public class AccountDto {
	
	@NotBlank(message = "Username is mandatory")
	private String username;
	
	@NotBlank(message = "Password is mandatory")
	@Password // custom validation
	private String password;
	
	@NotBlank
	private String confpassword;
	
	@NotBlank(message = "Email is mandatory")
	@Email
	private String email;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the confpassword
	 */
	public String getConfpassword() {
		return confpassword;
	}
	/**
	 * @param confpassword the confpassword to set
	 */
	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param username
	 * @param password
	 * @param confpassword
	 * @param email
	 */
	public AccountDto(String username, String password, String confpassword, String email) {
		super();
		this.username = username;
		this.password = password;
		this.confpassword = confpassword;
		this.email = email;
	}
	/**
	 * 
	 */
	public AccountDto() {
		super();
	}
}
