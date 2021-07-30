package com.revature.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Customer implements ICustomer {

	private int id;
	
	public String userName = "";


	private String password = "";

	private boolean isEmployee = false;

	//public HashMap<Item, Double> offerItems = new HashMap<Item, Double>();

	public ArrayList<Item> ownedItems = new ArrayList<Item>();

	public ArrayList<Double> remainingPayments = new ArrayList<Double>();

	
	public Customer(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	
	public Customer(int id, String userName, String password, boolean isEmployee) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.isEmployee = isEmployee;
	}



	public Customer() {
		// TODO Auto-generated constructor stub
	}

//	public HashMap<Item, Double> getOfferItems() {
//		return offerItems;
//	}
//
//	public void setOfferItems(HashMap<Item, Double> offerItems) {
//		this.offerItems = offerItems;
//	}

//	public void addOfferItem(Item item, Double price) {
//		offerItems.put(item, price);
//	}

	public int getId() {
		return id;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public boolean isEmployee() {
		return isEmployee;
	}
	
	
	
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	
	
	
	public ArrayList<Double> getRemainingPayments() {
		return remainingPayments;
	}
	
	
	
	public void setRemainingPayments(ArrayList<Double> remainingPayments) {
		this.remainingPayments = remainingPayments;
	}

	public ArrayList<Item> getOwnedItems() {
		return ownedItems;
	}

	public void setOwnedItems(ArrayList<Item> ownedItems) {
		this.ownedItems = ownedItems;
	}

	public void addOwnedItem(Item item) {
		this.ownedItems.add(item);
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
		if (this.userName == userName && this.password == password) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void rejectOffer(Item item, CopyOnWriteArrayList<Offer> offers) {

		
		for (Offer offer : offers) {
			if (offer.getCustomer().equals(this)) {
				
				offers.remove(offer);
			}
		}
	}

//	public void makeOffer(Item item, double offer) {
//
//		if (offer < 0) {
//			offer = 0;
//		}
//		
//		//offerItems.put(item, offer);
//	}

//	public void removeOffer(Item item) {
//		
//		// doesn't work yet (won't actually remove the item)
//		offerItems.remove(item);
//	}



	public ArrayList<Double> viewRemainingPayments() { 
		// TODO Auto-generated method stub 
		return remainingPayments;
	}

	public double makePayment(double payment) { 
		// TODO Auto-generated method stub
		return payment;

	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", password=" + password + ", isEmployee=" + isEmployee
				+ ", ownedItems=" + ownedItems + ", remainingPayments=" + remainingPayments + "]";
	}


	
}
