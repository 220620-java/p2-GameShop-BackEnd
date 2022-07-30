package com.revature.gameshop.services;

import com.revature.gameshop.models.User;

// User services interface
public interface UserServices {

	public User loginUser(String username, String password); 
	public User signUp(User user); 
	public User findUserById(Integer id); 
	public User findUserByName(String username); 
	public User updateUser(User user); 
	public User deleteUser(User user); 
}
