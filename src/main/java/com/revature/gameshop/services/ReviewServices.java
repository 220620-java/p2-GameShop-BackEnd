package com.revature.gameshop.services;

import com.revature.gameshop.models.Review;

public interface ReviewServices {

	public Review getReview(Integer id); 
	public Review addReview(Review r); 
	public Review updateReview(Review r); 
	public Review deleteReview(Review r); 
}
