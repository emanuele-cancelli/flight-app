/**
 * 
 */
package flight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flight.models.Bookmark;
import flight.repository.BookmarkRepository;
import flight.service.BookmarkService;

/**
 * @author Emanuele Cancelli
 *
 */
@Service
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	@Override
	public Bookmark addBookmark(Bookmark bookmark) {
		return bookmarkRepository.save(bookmark);
	}

	@Override
	public List<Bookmark> getBookmarkList(String username) {
		return bookmarkRepository.getBookmarkList(username);
	}

	@Override
	public void deleteBookmark(Long idBookmark) {
		bookmarkRepository.deleteById(idBookmark);
	}
}
