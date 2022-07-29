package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id; 
	private int role_id; 
	private String username; 
	private String passwd;
	
	
	
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", role_id=" + role_id + ", username=" + username + ", passwd=" + passwd
				+ "]";
	}
	public Users(int user_id, int role_id, String username, String passwd) {
		super();
		this.user_id = user_id;
		this.role_id = role_id;
		this.username = username;
		this.passwd = passwd;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	} 

}
