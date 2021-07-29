package com.revature.models;

import java.util.ArrayList;

public interface IEmployee extends IUser {
	
	public void addItemToShop(ArrayList<Item> items, Item item);
	
	public void removeItemFromShop(ArrayList<Item> items, Item item);
	
	public void acceptOffer(ArrayList<Customer> customers, Customer customerAccepted, Item item);
	
	public ArrayList<Double> viewAllPayments();
	
	// bonus items:
	//
	//public void editItem();
}
