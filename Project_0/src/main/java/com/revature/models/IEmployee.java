package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public interface IEmployee extends IUser {
	
	public void addItemToShop(ArrayList<Item> items, Item item);
	
	public void removeItemFromShop(ArrayList<Item> items, Item item);
	
	public void acceptOffer(Customer customerAccepted, Item item, List<Offer> offers);
	
	public ArrayList<Double> viewAllPayments();
	
	// bonus items:
	//
	//public void editItem();
}
