package com.revature.gameshop.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.revature.gameshop.models.Game;
import com.revature.gameshop.repository.GameRepository;


@Service
public class GameServicesImpl implements GameServices {
	
	GameRepository gameRepo; 
	
	public GameServicesImpl(GameRepository gameRepo) {
		this.gameRepo = gameRepo; 
	}
	

	@Override
	public Game getGame(Integer id) {
		// TODO Auto-generated method stub
		Optional<Game> gameOpt = gameRepo.findById(id);
		if (gameOpt.isPresent()) {
			return gameOpt.get(); 
		}else  {
			return null;

		}
		
	}

	@Override
	public Game addGame(Game g) {
		// TODO Auto-generated method stub
		Game game = gameRepo.save(g); 
		if (game != null) {
			return game;
		}
		return null;
	}

	@Override
	public Game updateGame(Game g) {
		// TODO Auto-generated method stub
		Game game = gameRepo.save(g); 
		if (game != null) {
			return game; 
		}
		return null;
	}

	@Override
	public Game deleteGame(Game g) {
		// TODO Auto-generated method stub
		try {
			gameRepo.delete(g);
			return g; 
		} catch (IllegalArgumentException e) {
			e.getMessage(); 
		}
		return null;
	}

}
