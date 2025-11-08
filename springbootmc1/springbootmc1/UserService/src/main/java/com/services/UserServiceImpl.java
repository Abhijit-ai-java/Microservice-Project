package com.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dao.UserRepository;
import com.model.Hotel;
import com.model.Rating;
import com.model.User;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	RestTemplate restTemplate;
	
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(int userId) {
		
				
			/*	Optional<User> user= userRepo.findById(userId);
				
				
			return user;*/
		
		//for microservices after register in eureka
		
		
		
		User user= userRepo.findById(userId).orElse(null);
		
		
		
		
		//http://localhost:8086/r/users/101
		
		Rating[] ratingOfUser=restTemplate.getForObject("http://localhost:8086/r/users/"+user.getUserId(), Rating[].class);
		
		logger.info("{}",ratingOfUser);
		
		 List<Rating> ratings=Arrays.stream(ratingOfUser).toList();
		
		List<Rating> ratingList=ratings.stream().map(rating->{
			
		/* extra code 
		 ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://localhost:8085/h/hotels/1001", Hotel.class);
		 
		
		http://localhost:8085/h/hotels/1001
		
	Hotel hotel=	forEntity.getBody();  */
			
		Hotel hotel=	restTemplate.getForObject("http://localhost:8085/h/hotels/"+rating.getHotelId(), Hotel.class);
			
	
	logger.info("{}",hotel);
	
	rating.setHotel(hotel);
	
		return rating;
		}).collect(Collectors.toList());
	
	
		
		user.setRatingList(ratingList);
		return user;
		
		
	}



}
