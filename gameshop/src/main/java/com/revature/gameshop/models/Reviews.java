package com.revature.gameshop.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reviews {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int review_id; 
	@ManyToOne(targetEntity = Game.class, fetch = FetchType.LAZY)
	@JoinColumn(name="game_id")
	//? Do I need to change the datatype of game_id to games
	private int game_id; 
	private int rating; 
	private String description;
	
	
	public Reviews() {
		super();
		this.review_id = 0;
		this.game_id = 0;
		this.rating = 1;
		this.description = null;
	}



	public int getReview_id() {
		return review_id;
	}



	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}



	public int getGame_id() {
		return game_id;
	}



	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Reviews [review_id=" + review_id + ", game_id=" + game_id + ", rating=" + rating + ", description="
				+ description + "]";
	}
	
	
	
	

	
}
