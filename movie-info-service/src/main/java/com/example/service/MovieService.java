package com.example.service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Movie;
import com.example.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	public Movie create(Movie movie) {
		if(repository.findByName(movie.getName()).isEmpty()) {
			movie.setReleaseDate(new Date());
			return repository.save(movie);
			
		} else {
			throw new RuntimeException("name already exits.");
		}
	}
	
	public List<Movie> getAll() {
		List<Movie> movieList = new ArrayList();
		repository.findAll().forEach(item -> movieList.add(item));
		return movieList.stream().sorted(Comparator.comparing(Movie::getName)).collect(Collectors.toList());
	}
	
	public Movie getById(long id) {
		return repository.findById(id).get();// fetching movie data from database base on movie id
	}
	
	//update only movie name
	public Movie update(Movie request) {
		Movie movie = repository.findById(request.getId()).get(); // fetching data from database base id
		movie.setName(request.getName()); // updating movie name which is coming from request int
		return repository.save(movie); // saving updated movie into database and return the same
	}

}
