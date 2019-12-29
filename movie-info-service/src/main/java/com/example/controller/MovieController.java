package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Movie;
import com.example.service.MovieService;

@RestController
@RequestMapping("/movie")

public class MovieController {
	
	@Autowired
	
	private MovieService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Movie movie){
		return new ResponseEntity (service.create(movie),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) {
		return new ResponseEntity(service.getById(id), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Movie movie) {
		return new ResponseEntity(service.update(movie), HttpStatus.OK);
	}

}
