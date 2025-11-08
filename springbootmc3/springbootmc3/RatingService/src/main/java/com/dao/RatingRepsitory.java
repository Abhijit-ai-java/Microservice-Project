package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Rating;

public interface RatingRepsitory extends JpaRepository<Rating,Integer>{

	List<Rating> findByUserId(int userId);
	List<Rating> findByHotelId(int hotelId);
}
