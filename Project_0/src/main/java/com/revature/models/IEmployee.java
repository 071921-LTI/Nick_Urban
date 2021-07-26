package com.revature.models;

public interface IEmployee extends IUser {
	
	public void addItemToShop();
	
	public void removeItemFromShop();
	
	public void considerOffer();
	
	public void viewAllPayments();
	
	// bonus items:
	//
	//public void editItem();
}
