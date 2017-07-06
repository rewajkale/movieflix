package io.egen.movieflix.service;
import java.util.Map;

import io.egen.movieflix.entity.Rating;

public interface RatingService {

	public double findByArguments(Map<String, String> params) ;

	public Rating findById(String id);
	
	public Rating create(Map<String, String> params,Rating rating);

	public Rating update(String id, Rating emp);

	public void delete(String id);
}
