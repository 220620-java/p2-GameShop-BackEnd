package com.revature.gameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gameshop.models.RentalHistory;

@Repository
public interface RentalHistoryRepository extends JpaRepository<RentalHistory, Integer> {

}
