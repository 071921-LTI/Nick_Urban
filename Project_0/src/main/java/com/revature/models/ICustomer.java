package com.revature.models;

public interface ICustomer extends IUser {

	public void makeOffer();
	
	public void registerAccount(); // maybe move somewhere else?
	
	public void viewItems();
	
	public void viewRemainingPayments();
	
	// bonus items:
	//
	//public void makePayment();
}
