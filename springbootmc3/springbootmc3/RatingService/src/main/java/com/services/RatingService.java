package com.services;

import java.util.List;

import com.model.Rating;

public interface RatingService {

	Rating create(Rating rating);
	
	List<Rating> getRatings();
	List<Rating> getRatingByUserId(int userId);
	List<Rating> getRatingByHotelId(int hotelId);
	
}
