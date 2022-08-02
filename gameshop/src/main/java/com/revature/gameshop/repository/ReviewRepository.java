package com.revature.gameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.gameshop.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
