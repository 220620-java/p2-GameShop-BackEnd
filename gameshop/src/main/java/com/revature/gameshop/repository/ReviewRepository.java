package com.revature.gameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gameshop.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
