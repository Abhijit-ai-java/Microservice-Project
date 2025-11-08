package com.services;

import java.util.List;
import java.util.Optional;

import com.model.User;

public interface UserService {
  
	User saveUser(User user);
	
	List<User> getAllUser();
	
	public User getUserById(int userId);
}
