package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id; 
	// Many to one. Many users an have the same role. 
	// mention parent column in JoinColumn/the field the foreign key is referencing too. 
	@ManyToOne
	@JoinColumn(name="role_id")
	private Status role_id; 
	private String username; 
	private String passwd;
	
	
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", role_id=" + role_id + ", "
				+ "username=" + username + ", passwd=" + passwd + "]";
	}
	public Users() {
		super();
		this.user_id = 0;
		this.role_id = new Status();
		this.username = "";
		this.passwd = "";
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Status getRole_id() {
		return role_id;
	}
	public void setRole_id(Status role_id) {
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
