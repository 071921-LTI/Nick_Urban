package com.revature.models;

import java.util.ArrayList;

public interface IEmployee extends IUser {
	
	public Item addItemToShop(Item item);
	
	public Item removeItemFromShop(Item item);
	
	public void acceptOffer(Customer customer, Item item);
	
	public ArrayList<Double> viewAllPayments();
	
	// bonus items:
	//
	//public void editItem();
}
