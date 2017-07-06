package io.egen.movieflix.repository;

import java.util.List;
import java.util.Map;

import io.egen.movieflix.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();

	public Movie findById(String id);

	public List<Movie> findByArguments(Map<String, String> params);
	
	public Movie create(Movie emp);

	public Movie update(Movie emp);

	public void delete(Movie emp);

	public Movie findByTitle(String title);
}
