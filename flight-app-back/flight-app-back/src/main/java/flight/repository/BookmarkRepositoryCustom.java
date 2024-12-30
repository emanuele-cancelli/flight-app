/**
 * 
 */
package flight.repository;

import java.util.List;

import flight.models.Bookmark;

/**
 * @author Emanuele Cancelli
 *
 */
public interface BookmarkRepositoryCustom {
	public List<Bookmark> getBookmarkList(String username);
}
