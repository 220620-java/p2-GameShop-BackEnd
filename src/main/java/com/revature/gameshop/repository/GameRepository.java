package com.revature.gameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gameshop.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>  {

}
