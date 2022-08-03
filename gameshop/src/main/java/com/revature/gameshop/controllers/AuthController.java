package com.revature.gameshop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gameshop.models.User;
import com.revature.gameshop.services.UserServices;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
	
	private UserServices userServ; 
	//private ToKenService tokenServ; 
	
	public AuthController(UserServices userServ) {
		this.userServ = userServ; 
	}
	
	@PostMapping 
	public ResponseEntity<User> login(@RequestBody User user) {
		
		String username = user.getUsername(); 
		String password = user.getPasswd(); 
		
		User u = userServ.loginUser(username, password); 
		if (u != null) {
			return ResponseEntity.status(200).header("Auth", "gamshop2022").body(null); 
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
		
	}

}
