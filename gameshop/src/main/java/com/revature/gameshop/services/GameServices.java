package com.revature.gameshop.services;

import com.revature.gameshop.models.Game;

public interface GameServices {
	
	public Game getGame(Integer id); 
	public Game addGame(Game game); 
	public Game updateGame(Game game); 
	public Game deleteGame(Game game); 

}
