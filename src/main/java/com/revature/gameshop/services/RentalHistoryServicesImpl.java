package com.revature.gameshop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.gameshop.models.Game;
import com.revature.gameshop.models.RentalHistory;
import com.revature.gameshop.models.Review;
import com.revature.gameshop.models.User;
import com.revature.gameshop.repository.GameRepository;
import com.revature.gameshop.repository.RentalHistoryRepository;
import com.revature.gameshop.repository.UserRepository;


@Service
public class RentalHistoryServicesImpl implements RentalHistoryServices {
	
	private GameRepository gameRepo; 
	private UserRepository userRepo; 
	private RentalHistoryRepository rentalRepo; 
	
	public RentalHistoryServicesImpl(GameRepository gameRepo, 
									 UserRepository userRepo, 
									 RentalHistoryRepository rentalRepo) {
		this.gameRepo = gameRepo; 
		this.userRepo = userRepo; 
		this.rentalRepo = rentalRepo; 
	}

	@Override
	public RentalHistory getHistory(Integer id) {
		// TODO Auto-generated method stub
		Optional<RentalHistory> historyOpt = rentalRepo.findById(id); 
		if (historyOpt.isPresent()) {
			return historyOpt.get();
		}
		
		return null;
		
	}

	@Override
	public RentalHistory addHistory(RentalHistory history) {
		
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepo.findById(history.getUser_id().getUser_id()); 
		Optional<Game> gameOpt = gameRepo.findById(history.getGame_id().getGame_id()); 
		if (userOpt.isPresent() && gameOpt.isPresent()) {
			history.setUser_id(userOpt.get());
			history.setGame_id(gameOpt.get());
			history = rentalRepo.save(history); 
			if (history != null) {
				return history; 
			} else {
				return null; 
			}
		}else {
			return null; 
		}		
	}

	@Override
	public RentalHistory updateHistory(RentalHistory history) {
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepo.findById(history.getUser_id().getUser_id()); 
		Optional<Game> gameOpt = gameRepo.findById(history.getGame_id().getGame_id()); 
		if (userOpt.isPresent() && gameOpt.isPresent()) {
			history.setUser_id(userOpt.get());
			history.setGame_id(gameOpt.get());
			history = rentalRepo.save(history); 
			if (history != null) {
				return history; 
			} else {
				return null; 
			}
		}else {
			return null; 
		}		
	}

	@Override
	public RentalHistory deleteHistor(RentalHistory history) {
		// TODO Auto-generated method stub
		try {
			rentalRepo.delete(history);
			return history; 
			
		} catch (IllegalArgumentException e) {
			e.getMessage(); 
		}
		return null;
	}

}
