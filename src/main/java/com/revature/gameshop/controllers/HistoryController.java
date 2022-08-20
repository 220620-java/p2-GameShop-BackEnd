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

import com.revature.gameshop.models.RentalHistory;
import com.revature.gameshop.services.RentalHistoryServices;

@RestController
@RequestMapping(path="/history")
public class HistoryController {
	
	RentalHistoryServices rentalService; 
	
	public HistoryController(RentalHistoryServices rentalService) {
		this.rentalService = rentalService; 
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<RentalHistory> getHistory(@PathVariable("id") Integer rental_id) {
		
		if (rental_id instanceof Integer) {
			RentalHistory history = rentalService.getHistory(rental_id); 
			if (history != null) {
				return ResponseEntity.ok(history);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
		return null;
		
	}
	
	@PostMapping
	public ResponseEntity<RentalHistory> addHistory(@RequestBody RentalHistory history) {
		if (history != null) {
			history = rentalService.addHistory(history); 
			return ResponseEntity.ok(history); 
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
	}
	
	@PutMapping(path="/{id}") 
	public ResponseEntity<RentalHistory> updateHistory(@RequestBody RentalHistory history, 
			@PathVariable("id") Integer rental_id) {
		if (history != null && rental_id instanceof Integer && history.getRental_id() == rental_id) {
			history = rentalService.updateHistory(history); 
			return ResponseEntity.ok(history); 
		}else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build(); 
		}
		
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<RentalHistory> deleteReview(@RequestBody RentalHistory history, 
			@PathVariable("id") Integer rental_id) {
		// TODO: user.getLoggedIn()
		if (history!= null && history.getRental_id() == rental_id) {
			history = rentalService.deleteHistor(history); 
			return ResponseEntity.ok(history); 
		}else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	}
	
	
	

}
