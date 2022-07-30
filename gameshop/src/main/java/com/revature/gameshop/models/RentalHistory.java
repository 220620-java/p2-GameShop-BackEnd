package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RentalHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rental_id; 
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private int user_id; 
	@ManyToOne
	@JoinColumn(name="game_id")
	private int game_id; 
	private String rentalStatus;
	
	public RentalHistory() {
		super();
		this.rental_id = 0;
		this.user_id = 0;
		this.game_id = 0;
		this.rentalStatus = "Current";
	}

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}

	public String getRentalStatus() {
		return rentalStatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalStatus = rentalStatus;
	}

	@Override
	public String toString() {
		return "RentalHistory [rental_id=" + rental_id + ", user_id=" + user_id + ", game_id=" + game_id
				+ ", rentalStatus=" + rentalStatus + "]";
	}
	
	
	
	
}
