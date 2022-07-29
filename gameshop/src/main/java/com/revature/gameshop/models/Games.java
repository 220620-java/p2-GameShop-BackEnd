package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Games {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int game_id; 
	private String gameName;
	private String gameGenre; 
	private String developeName; 
	private int rentalDays;
	
	
	public Games(int game_id, String gameName, String gameGenre, String developeName, int rentalDays) {
		super();
		this.game_id = game_id;
		this.gameName = gameName;
		this.gameGenre = gameGenre;
		this.developeName = developeName;
		this.rentalDays = rentalDays;
	}


	public int getGame_id() {
		return game_id;
	}


	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}


	public String getGameName() {
		return gameName;
	}


	public void setGameName(String gameName) {
		this.gameName = gameName;
	}


	public String getGameGenre() {
		return gameGenre;
	}


	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}


	public String getDevelopeName() {
		return developeName;
	}


	public void setDevelopeName(String developeName) {
		this.developeName = developeName;
	}


	public int getRentalDays() {
		return rentalDays;
	}


	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}


	@Override
	public String toString() {
		return "Games [game_id=" + game_id + ", gameName=" + gameName + ", gameGenre=" + gameGenre + ", developeName="
				+ developeName + ", rentalDays=" + rentalDays + "]";
	}  
	
	
}
