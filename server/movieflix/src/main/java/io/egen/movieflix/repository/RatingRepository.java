package io.egen.movieflix.repository;

import java.util.List;
import java.util.Map;

import io.egen.movieflix.entity.Rating;

public interface RatingRepository {

	public double findByArguments(Map<String, String> params);

	public Rating findById(String id);

	public List<Rating> findByUserIdMovieId(String userId, String movieId);
	
	public Rating create(Rating emp);

	public Rating update(Rating emp);

	public void delete(Rating emp);
}
