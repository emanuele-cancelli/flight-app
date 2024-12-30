/**
 * 
 */
package flight.service;

import java.util.List;

import flight.models.Bookmark;

/**
 * @author Emanuele Cancelli
 *
 */
public interface BookmarkService {
	Bookmark addBookmark(Bookmark bookmark);
	List<Bookmark> getBookmarkList(String username);
	void deleteBookmark(Long idBookmark);
}
