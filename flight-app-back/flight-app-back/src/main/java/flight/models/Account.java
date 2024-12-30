/**
 * 
 */
package flight.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Emanuele Cancelli
 *
 */
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAccount;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String confpassword;
	@Column
	private String email;
	@Column
	private boolean enabled;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Bookmark> bookmarks;
	/**
	 * @return the idAccount
	 */
	public long getIdAccount() {
		return idAccount;
	}
	/**
	 * @param idAccount the idAccount to set
	 */
	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}
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
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return the bookmarks
	 */
	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}
	/**
	 * @param bookmarks the bookmarks to set
	 */
	public void setBookmarks(Set<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}
	/**
	 * @param idAccount
	 * @param username
	 * @param password
	 * @param confpassword
	 * @param email
	 * @param enabled
	 * @param bookmarks
	 */
	public Account(long idAccount, String username, String password, String confpassword, String email, boolean enabled,
			Set<Bookmark> bookmarks) {
		super();
		this.idAccount = idAccount;
		this.username = username;
		this.password = password;
		this.confpassword = confpassword;
		this.email = email;
		this.enabled = enabled;
		this.bookmarks = bookmarks;
	}
	/**
	 * 
	 */
	public Account() {
		super();
		this.enabled = false;
	}
}
