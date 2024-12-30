/**
 * 
 */
package flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flight.models.Bookmark;

/**
 * @author Emanuele Cancelli
 *
 */
@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long>, BookmarkRepositoryCustom {
	
}
