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

import com.revature.gameshop.auth.Auth;
import com.revature.gameshop.models.Game;
import com.revature.gameshop.models.User;
import com.revature.gameshop.services.GameServices;

@RestController
@RequestMapping(path="/games")
public class GameController {
	
	private GameServices gameService; 
	
	public GameController(GameServices gameService) {
		this.gameService = gameService; 
	}
	
	@GetMapping(path = "/{id}") 
	public ResponseEntity<Game> getGame(@PathVariable("id") Integer game_id) {
		
		if (game_id instanceof Integer) {
			Game game = gameService.getGame(game_id); 
			if (game != null) {
				return ResponseEntity.ok(game); 
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}	
		}else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Game> addGame(@RequestBody Game game) {
		
		if (game != null) {
			game = gameService.addGame(game); 
			if (game != null) {
				return ResponseEntity.ok(game); 
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
			}
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Game> updateGame(@RequestBody Game game, @PathVariable("id") Integer game_id) {
		
		if (game != null && game.getGame_id() == game_id) {
			game = gameService.updateGame(game); 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(game); 
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Game> deleteUser(@RequestBody Game game, @PathVariable("id") Integer game_id) {
		if (game != null && game.getGame_id() == game_id) {
			game = gameService.deleteGame(game); 
			return ResponseEntity.ok(game); 
		}else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	}

}
