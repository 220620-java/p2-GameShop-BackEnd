package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int role_id; 
	private String role_name; 
	private String role_description;
	
	
	public Status(int role_id, String role_name, String role_description) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_description = role_description;
	}


	public Status() {
		// TODO Auto-generated constructor stub
	}


	public int getRole_id() {
		return role_id;
	}


	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	public String getRole_description() {
		return role_description;
	}


	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}


	@Override
	public String toString() {
		return "Status [role_id=" + role_id + ", role_name=" + role_name + ", role_description=" + role_description
				+ "]";
	} 
	
	
	
}
