package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Rating;
import com.services.RatingService;

@RestController
@RequestMapping("r")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
   @PostMapping("/save")	
	public ResponseEntity<Rating>  addRating(@RequestBody Rating rating)
	{
		Rating rating1=ratingService.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "save rating").body(rating1);
	}
   
   @GetMapping("/getAll")
	public ResponseEntity<List<Rating>> getAllRatings() {
	    List<Rating> ratings = ratingService.getRatings();
	    return ResponseEntity.ok(ratings); 
	}
   
   @GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable int userId) {
	    List<Rating> ratings = ratingService.getRatingByUserId(userId);
	    return ResponseEntity.ok(ratings); 
	}
  
	
   @GetMapping("/hotels/{hotelId}")
  	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable int hotelId) {
  	    List<Rating> ratings = ratingService.getRatingByUserId(hotelId);
  	    return ResponseEntity.ok(ratings); 
  	}
    
}
