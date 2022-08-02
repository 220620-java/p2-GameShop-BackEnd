package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name="users", schema="gameshop")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id; 
	// Many to one. Many users an have the same role. 
	// mention parent column in JoinColumn/the field the foreign key is referencing too. 
	@ManyToOne()
	@JoinColumn(name="role_id")
	private Role role_id; 
	private String username; 
	private String passwd;
	private static boolean loggedIn = false; 
	
	
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", role_id=" + role_id + ", "
				+ "username=" + username + ", passwd=" + passwd + "]";
	}
	
	
	public User(int user_id, String username, String passwd) {
		super();
		this.user_id = user_id;
		this.role_id = new Role();
		this.username = username;
		this.passwd = passwd;	 
	}


	public User() {
		super();
		this.user_id = 0;
		this.role_id = new Role();
		this.username = "";
		this.passwd = "";
		
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Role getRole_id() {
		return role_id;
	}
	public void setRole_id(Role role_id) {
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
	
	public static void setLoggedIn(Boolean s) {
		loggedIn = true; 
	}
	
	public static Boolean getLoggedIn() {
		return loggedIn; 
	}

}
