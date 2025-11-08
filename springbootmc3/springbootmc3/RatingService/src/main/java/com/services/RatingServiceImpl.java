package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RatingRepsitory;
import com.model.Rating;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepsitory ratingRepo;
	
	@Override
	public Rating create(Rating rating) {
		
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
	
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(int userId) {
	
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(int hotelId) {
		
		return ratingRepo.findByHotelId(hotelId);
	}

	
}
