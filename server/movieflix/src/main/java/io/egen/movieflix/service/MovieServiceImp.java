package io.egen.movieflix.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.exception.EntityAlreadyExistsException;
import io.egen.movieflix.exception.EntityNotFoundException;
import io.egen.movieflix.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findById(String id) {
		Movie existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie with id:" + id + " not found");
		}
		return existing;
	}
	
	@Override
	public List<Movie> findByArguments(Map<String, String> params) {
	
		return repository.findByArguments(params);
	}
	
	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if (existing != null) {
			throw new EntityAlreadyExistsException("Movie Already exists: " + movie.getTitle());
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie emp) {
		Movie existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie with id:" + id + " not found");
		}
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
