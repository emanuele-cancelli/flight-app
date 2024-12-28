/**
 * 
 */
package flight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import flight.dto.AccountDto;
import flight.models.Account;
import flight.repository.AccountRepository;
import flight.service.AccountService;

/**
 * @author Emanuele Cancelli
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Account addAccount(AccountDto accountDto) {
		Account account = new Account();
		account.setUsername(accountDto.getUsername());
		account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
		account.setConfpassword(passwordEncoder.encode(accountDto.getConfpassword()));
		account.setEmail(accountDto.getEmail());
		return accountRepository.save(account);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return null;
	}
}
