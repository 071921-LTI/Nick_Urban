package com.revature.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Employee implements IEmployee {

	public String userName = "";

	private String password = "";

	private boolean isEmployee = true;

	
	
	
	public Employee(String userName, String password, boolean isEmployee) {
		super();
		this.userName = userName;
		this.password = password;
		this.isEmployee = isEmployee;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmployeeCheck() {
		return isEmployee;
	}

	public boolean logIn(String userName, String password) {

		// put in try-catch for exception(s) handling
		if (this.userName == userName && this.password == password && isEmployee) {
			return true;
		} else {
			return false;
		}

	}

	public void acceptOffer(Customer customer, Item item) {

		HashMap<Item, Double> offerItems = customer.getOfferItems();

		for (Map.Entry mapElement : offerItems.entrySet()) {
			Item key = (Item) mapElement.getKey();
			Double value = (Double) mapElement.getValue();
			if (key.equals(item)) {
				customer.addOwnedItem(item);
				item.setOwned(true);
				item.setSoldPrice(value);
			}
		}
	}


	public Item addItemToShop(Item item) { 
		// TODO Auto-generated method stub
		item = new Item();
		return item;
	}

	public Item removeItemFromShop(Item item) { 
		// TODO Auto-generated method stub
		item = new Item();
		return item;

	}


	public ArrayList<Double> viewAllPayments() { 
		// TODO Auto-generated method stub
		ArrayList<Double> payments = new ArrayList<Double>();
		return payments;

	}
}
