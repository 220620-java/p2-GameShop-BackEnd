package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rentalhistory", schema="gameshop")
public class RentalHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rental_id; 
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user_id; 
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game_id; 
	private String rentalstatus;
	
	public RentalHistory() {
		super();
		this.rental_id = 0;
		this.user_id = new User();
		this.game_id = new Game();
		this.rentalstatus = "";
	}
	
	

	public RentalHistory(int rental_id, User user_id, Game game_id, String rentalstatus) {
		super();
		this.rental_id = rental_id;
		this.user_id = user_id;
		this.game_id = game_id;
		this.rentalstatus = rentalstatus;
	}



	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Game getGame_id() {
		return game_id;
	}

	public void setGame_id(Game game_id) {
		this.game_id = game_id;
	}

	public String getRentalStatus() {
		return rentalstatus;
	}

	public void setRentalStatus(String rentalStatus) {
		this.rentalstatus = rentalStatus;
	}

	@Override
	public String toString() {
		return "RentalHistory [rental_id=" + rental_id + ", user_id=" + user_id + ", game_id=" + game_id
				+ ", rentalStatus=" + rentalstatus + "]";
	}
	
	
	
	
}
