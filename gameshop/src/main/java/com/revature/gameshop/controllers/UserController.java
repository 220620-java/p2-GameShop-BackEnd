package com.revature.gameshop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gameshop.models.User;
import com.revature.gameshop.services.UserServices;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	
	private UserServices userService; 
	
	// constructor injection
	public UserController(UserServices userService) {
		this.userService = userService; 
	}
	
	// Retrieves user by id
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer user_id) {
		User user = userService.findUserById(user_id); 
		if (user != null) {
			return ResponseEntity.ok(user); 
		}else {
			return ResponseEntity.notFound().build(); 
		}		
	}
	
	// Add user to the database. The body includes the user
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		try {
			user = userService.signUp(user); 
			return ResponseEntity.status(HttpStatus.CREATED).body(user); 
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null; 
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Integer user_id) {
		
		if (user != null && user.getUser_id() == user_id) {
			user = userService.updateUser(user); 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(user); 
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<User> deleteUser(@RequestBody User user, @PathVariable("id") Integer user_id) {
		if (user != null && user.getUser_id() == user_id) {
			user = userService.deleteUser(user); 
			return ResponseEntity.ok(user); 
		}else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	}

}

