/**
 * 
 */
package flight.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import flight.models.Account;

/**
 * @author Emanuele Cancelli
 *
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

}
