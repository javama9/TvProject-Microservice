package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
	public List<Movie> findByName(String name);

}
