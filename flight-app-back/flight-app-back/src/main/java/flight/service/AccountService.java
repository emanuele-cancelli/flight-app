/**
 * 
 */
package flight.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import flight.dto.AccountDto;
import flight.models.Account;

/**
 * @author Emanuele Cancelli
 *
 */
public interface AccountService extends UserDetailsService{

	Account addAccount(AccountDto accountDto);
}
