package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HotelRepository;
import com.model.Hotel;


@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	public HotelRepository hotelRepo;	
	
	@Override
	public Hotel create(Hotel hotel) {
		
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
	
		return hotelRepo.findAll();
	}

	@Override
	public Optional<Hotel> getOneHotel(int id) {	
		
		return hotelRepo.findById(id);
	}

}
