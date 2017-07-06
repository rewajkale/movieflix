package io.egen.movieflix.repository;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.movieflix.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findById(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public List<Movie> findByArguments(Map<String, String> params) {
		TypedQuery<Movie> query=null;
		
		if(params.get("type")!=null)
		{	
			if(params.get("sort")=="year")
				query = em.createNamedQuery("Movie.findByTypeSortByYear", Movie.class);
			else if(params.get("sort")=="rating") 
				query = em.createNamedQuery("Movie.findByTypeSortByRating", Movie.class);
			else if(params.get("sort")=="votes") 
				query = em.createNamedQuery("Movie.findByTypeSortByVotes", Movie.class);
			else
				query = em.createNamedQuery("Movie.findByType", Movie.class);
			query.setParameter("pType", params.get("type")); 
		}	
		else if(params.get("year")!=null)
		{
			if(params.get("sort")=="year")
				query = em.createNamedQuery("Movie.findByYearSortByYear", Movie.class);
			else if(params.get("sort")=="rating") 
				query = em.createNamedQuery("Movie.findByYearSortByRating", Movie.class);
			else if(params.get("sort")=="votes") 
				query = em.createNamedQuery("Movie.findByYearSortByVotes", Movie.class);
			else
				query = em.createNamedQuery("Movie.findByYear", Movie.class);
			query.setParameter("pYear", Integer.parseInt(params.get("year")));
		}
		else if(params.get("genre")!=null)
		{
			if(params.get("sort")=="year")
				query = em.createNamedQuery("Movie.findByGenreSortByYear", Movie.class);
			else if(params.get("sort")=="rating") 
				query = em.createNamedQuery("Movie.findByGenreSortByRating", Movie.class);
			else if(params.get("sort")=="votes") 
				query = em.createNamedQuery("Movie.findByGenreSortByVotes", Movie.class);
			else
				query = em.createNamedQuery("Movie.findByGenre", Movie.class);
			query.setParameter("pGenre", params.get("genre"));
		}
		else
		{

			if(params.get("sort")=="year")
				query = em.createNamedQuery("Movie.findAllSortByYear", Movie.class);
			else if(params.get("sort")=="rating") 
				query = em.createNamedQuery("Movie.findAllSortByRating", Movie.class);
			else if(params.get("sort")=="votes") 
				query = em.createNamedQuery("Movie.findAllSortByVotes", Movie.class);
			else
				query = em.createNamedQuery("Movie.findAll", Movie.class);
		}
		
		List<Movie> movies = query.getResultList();
		return movies;
	}
	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> Movies = query.getResultList();
		if (Movies != null && Movies.size() == 1) {
			return Movies.get(0);
		}
		return null;
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie emp) {
		return em.merge(emp);
	}

	@Override
	public void delete(Movie emp) {
		em.remove(emp);
	}
}
