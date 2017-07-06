package io.egen.movieflix.repository;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.movieflix.entity.Comment;

@Repository
public class CommentRepositoryImp implements CommentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Comment> findByArguments(Map<String, String> params) {
		TypedQuery<Comment> query;
		if(params.get("movieId")!=null)
		{	
			query = em.createNamedQuery("Comment.findByMovieId", Comment.class);
			query.setParameter("pMovieId", params.get("movieId")); 
		}
		else
			query = em.createNamedQuery("Comment.findAll", Comment.class);
		return query.getResultList();
	}

	@Override
	public Comment findById(String id) {
		return em.find(Comment.class, id);
	}

	@Override
	public Comment create(Comment comment) {
		em.persist(comment);
		return comment;
	}

	@Override
	public Comment update(Comment emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(Comment emp) {
		em.remove(emp);
	}
}
