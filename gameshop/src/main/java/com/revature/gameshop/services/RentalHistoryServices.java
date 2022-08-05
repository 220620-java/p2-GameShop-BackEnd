package com.revature.gameshop.services;

import com.revature.gameshop.models.RentalHistory;

public interface RentalHistoryServices {
	
	public RentalHistory getHistory(Integer id); 
	public RentalHistory addHistory(RentalHistory history); 
	public RentalHistory updateHistory(RentalHistory history); 
	public RentalHistory deleteHistor(RentalHistory history); 


}
