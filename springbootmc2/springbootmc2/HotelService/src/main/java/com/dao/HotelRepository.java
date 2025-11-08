package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
	

}
