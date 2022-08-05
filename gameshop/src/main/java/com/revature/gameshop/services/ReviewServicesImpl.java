package com.revature.gameshop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.gameshop.models.Game;
import com.revature.gameshop.models.Review;
import com.revature.gameshop.repository.GameRepository;
import com.revature.gameshop.repository.ReviewRepository;

@Service
public class ReviewServicesImpl implements ReviewServices {
	
	private ReviewRepository reviewRepo; 
	private GameRepository gameRepo; 
	
	public ReviewServicesImpl(ReviewRepository reviewRepo,GameRepository gameRepo) {
		this.reviewRepo = reviewRepo; 
		this.gameRepo = gameRepo; 
	}

	@Override
	public Review getReview(Integer id) {
		// TODO Auto-generated method stub
		Optional<Review> reviewOpt = reviewRepo.findById(id); 
		if (reviewOpt.isPresent()) {
			return reviewOpt.get();
		}
		
		return null;
	}

	@Override
	public Review addReview(Review r) {
		// TODO Auto-generated method stub
		Optional<Game> gameOpt = gameRepo.findById(r.getGame_id().getGame_id()); 
		if (gameOpt.isPresent()) {
			r.setGame_id(gameOpt.get());
			r = reviewRepo.save(r); 
			if (r != null) {
			return r; 
			}
		}
		return null;
	}

	@Override
	public Review updateReview(Review r) {
		// TODO Auto-generated method stub
		r = addReview(r); 
		if (r != null) {
			return r; 
		}
		return null;
	}

	@Override
	public Review deleteReview(Review r) {
		// TODO Auto-generated method stub
		try {
			reviewRepo.delete(r);
			return r; 
		} catch (IllegalArgumentException e) {
			e.getMessage(); 
		}
		return null;
	}

}
