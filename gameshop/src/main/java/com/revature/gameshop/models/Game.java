package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="games", schema="gameshop")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int game_id; 
	private int quantity;
	
	
	public Game() {
		super();
		this.game_id = 0;
		this.quantity = 0;
	}


	public int getGame_id() {
		return game_id;
	}


	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Games [game_id=" + game_id + ", quantity=" + quantity + "]";
	} 	
}
