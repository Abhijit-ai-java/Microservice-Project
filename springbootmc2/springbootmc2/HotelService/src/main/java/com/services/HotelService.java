package com.services;

import java.util.List;
import java.util.Optional;

import com.model.Hotel;

public interface HotelService {

	public Hotel create(Hotel hotel);
	public List<Hotel> getAll();
	public Optional<Hotel> getOneHotel(int id);
}
