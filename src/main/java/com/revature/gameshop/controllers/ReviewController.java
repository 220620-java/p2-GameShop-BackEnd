package com.revature.gameshop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.gameshop.models.Review;
import com.revature.gameshop.services.ReviewServices;

@RestController
@RequestMapping(path="/reviews")
public class ReviewController {
	 
	private ReviewServices reviewService; 
	
	public ReviewController(ReviewServices reviewService) {
		this.reviewService = reviewService; 
		
	}

	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Review> getReview(@PathVariable("id") Integer review_id) {
		
		if (review_id instanceof Integer) {
			Review review = reviewService.getReview(review_id); 
			if (review != null) {
				return ResponseEntity.ok(review); 
			} else {
				return ResponseEntity.notFound().build();
			}
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	@PostMapping
	public ResponseEntity<Review> addReview(@RequestBody Review review) {
		//TODO : user.getLoggedIn()
		if (review != null) {
			review = reviewService.addReview(review); 
			if (review != null) {
				return ResponseEntity.ok(review); 
			}else {
				return ResponseEntity.noContent().build();
			}
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Review> updateReview(@RequestBody Review review, 
			@PathVariable("id") Integer review_id) {
		// TODO : user.getLoggedIn()
		if (review != null && review.getReview_id() == review_id) {
			review = reviewService.updateReview(review); 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(review); 
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
	}
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Review> deleteReview(@RequestBody Review review, 
			@PathVariable("id") Integer review_id) {
		// TODO: user.getLoggedIn()
		if (review!= null && review.getReview_id() == review_id) {
			review = reviewService.deleteReview(review); 
			return ResponseEntity.ok(review); 
		}else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	}
}
