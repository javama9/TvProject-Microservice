package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserRating;
import com.example.service.UserRatingService;

@RestController
@RequestMapping("/rating")
public class UserRatingController {
	
	@Autowired
	private UserRatingService service;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody UserRating userRating) {
		return new ResponseEntity(service.save(userRating), HttpStatus.OK);
	}

}
