package com.example.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.model.Movie;

@Component
public class MovieGateway {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Movie getMovieById(Long id) {
		//Movie movie = restTemplate.getForEntity("http://localhost:8086/movie/"+id, Movie.class).getBody();
		Movie movie = restTemplate.getForEntity("http://movie-info-service/movie/"+id, Movie.class).getBody();
		return movie;
	}

}// https://dzone.com/articles/lifecycle-of-a-request-response-process-for-a-spri
// if service is not up and running then we use Hystrix to write a alternative method to handle it