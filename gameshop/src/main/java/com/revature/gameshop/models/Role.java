package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles", schema="gameshop")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int role_id; 
	private String role_name; 
	private String role_description;
	
	
	public Role() {
		this.role_id = 1;
		this.role_name = "User";
		this.role_description = "Game customer"; 
	}

//	public Role(int roleId, String role_name, String role_description) {
//		this.role_id = roleId;
//		this.role_name = role_name;
//		this.role_description = role_description;
//	}



	public int getRole_id() {
		return role_id;
	}


	public void setRoleId(int role) {
		this.role_id = role;
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
