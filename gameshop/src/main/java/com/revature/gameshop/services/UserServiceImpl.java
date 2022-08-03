package com.revature.gameshop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.gameshop.models.Role;
import com.revature.gameshop.models.User;
import com.revature.gameshop.repository.RoleRepository;
import com.revature.gameshop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServices {
	
	private UserRepository userRepo; 
	private RoleRepository roleRepo; 
	
	public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo; 
	}
 
	@Override
	public User loginUser(String username, String password) {
		// TODO Auto-generated method stub
		if (username != null && password != null) {
			User user = userRepo.findByUsername(username); 
			if (user != null && password.equals(user.getPasswd())) {
				return user; 
			}
		}
		return null;
	}

	@Override
	public User signUp(User user) {
		// TODO Auto-generated method stub
		if (user != null) {
			Optional<Role> role = roleRepo.findById(user.getRole_id().getRole_id()); 
			if (role.isPresent()) {
				user.setRole_id(role.get());
				return userRepo.save(user); 
			}
		}
		return null;
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		if (id instanceof Integer) {
			Optional<User> userOpt = userRepo.findById(id); 
			if (userOpt.isPresent()) {
				return userOpt.get(); 
			}
		}
		return null;
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		if (username != null) {
			User user = userRepo.findByUsername(username); 
			if (user != null) {
				return user; 
			}
		}
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		if (user != null) {
			user = userRepo.save(user); 
			return user; 
		}
		return null;
	}

	@Override
	public User deleteUser(User user) {
		// TODO Auto-generated method stub
		if (user != null) {
			userRepo.delete(user);
			return user; 
		}
		return null; 
		
	}

}
