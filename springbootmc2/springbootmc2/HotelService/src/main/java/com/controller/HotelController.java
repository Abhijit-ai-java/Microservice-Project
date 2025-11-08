package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Hotel;
import com.services.HotelService;

@RestController
@RequestMapping("h")
public class HotelController {
	
	@Autowired
	HotelService hotelService;

@PostMapping("/save")
	
	public ResponseEntity<Hotel>  addUser(@RequestBody Hotel hotel)
	{
		Hotel hotel1=hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "save hotel").body(hotel1);
	}

@GetMapping("/getAll")
public ResponseEntity<List<Hotel>> getAllHotel() {
    List<Hotel> hotels = hotelService.getAll();
    return ResponseEntity.ok(hotels); 
}

@GetMapping("/hotels/{id}")
public ResponseEntity<Hotel> getHotelById(@PathVariable int id) {
    Optional<Hotel> hotel = hotelService.getOneHotel(id);

 
    if (hotel.isPresent()) {
        return ResponseEntity.ok(hotel.get());
    } else {
        
        return ResponseEntity.notFound().build();
    }
}
	
}
