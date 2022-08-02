package com.revature.gameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gameshop.models.Game;

public interface GameRepository extends JpaRepository<Game, Integer>  {

}
