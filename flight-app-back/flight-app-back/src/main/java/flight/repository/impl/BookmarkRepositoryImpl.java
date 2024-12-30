/**
 * 
 */
package flight.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flight.models.Bookmark;
import flight.repository.BookmarkRepositoryCustom;

/**
 * @author Emanuele Cancelli
 *
 */
@Repository
public class BookmarkRepositoryImpl implements BookmarkRepositoryCustom {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Bookmark> getBookmarkList(String username) {
		CriteriaBuilder cbuild = entityManager.getCriteriaBuilder();
		// specify the return type
		CriteriaQuery<Bookmark> cquery = cbuild.createQuery(Bookmark.class);
		// root is the entity type in the from clause
		Root<Bookmark> bookmark = cquery.from(Bookmark.class);
		// predicates are where conditions
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cbuild.equal(bookmark.get("account").get("username"), username));
		cquery.where(predicates.toArray(new Predicate[0]));
		return entityManager.createQuery(cquery).getResultList();
	}
}
