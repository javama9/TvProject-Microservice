package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.UserRating;

@Repository
public interface UserRatingRepository extends CrudRepository<UserRating, Long> {

}
