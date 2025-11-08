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

import com.model.User;
import com.services.UserService;

@RestController
@RequestMapping("u")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/users/save")
	
	public ResponseEntity<User>  addUser(@RequestBody User user)
	{
		User user1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).header("add", "save user").body(user);
	}
	
	@GetMapping("/users/getAll")
	public ResponseEntity<List<User>> getAllUser() {
	    List<User> users = userService.getAllUser();
	    return ResponseEntity.ok(users); 
	}
	
	
	@GetMapping("/users/{userId}")
    public ResponseEntity<User> findUserDataById(@PathVariable int userId) {
        User user = userService.getUserById(userId);

     
        if (user!=null) {
            return ResponseEntity.ok(user);  //http://192.168.20.11:8084/u/users/101  fetch from registiry it will show output
        } else {
            
            return ResponseEntity.notFound().build();
        }
    }

	
}
