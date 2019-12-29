package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gateway.MovieGateway;
import com.example.model.Movie;
import com.example.model.UserRating;
import com.example.repository.UserRatingRepository;

@Service
public class UserRatingService {
	
	@Autowired
	private UserRatingRepository repository;
	
	@Autowired
	private MovieGateway movieGateway;
	
	public UserRating save(UserRating userRating) {
		Movie movie = movieGateway.getMovieById(userRating.getMovieId());
		if(movie == null) {
			throw new RuntimeException("movie id is invalid");
		}
		
		return repository.save(userRating);
	}
	

}
