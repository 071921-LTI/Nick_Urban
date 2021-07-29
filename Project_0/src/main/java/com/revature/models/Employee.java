package com.revature.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.revature.services.ItemServices;

public class Employee implements IEmployee {

	private int id;
	
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

	public void acceptOffer(Customer customerAccepted, Item item, List<Offer> offers) {

//		for (Customer currentCustomer : customers ) {
//			
//			if (currentCustomer.equals(customerAccepted)) {
//				HashMap<Item, Double> offerItems = currentCustomer.getOfferItems();
//
//				for (Map.Entry mapElement : offerItems.entrySet()) {
//					Item key = (Item) mapElement.getKey();
//					Double value = (Double) mapElement.getValue();
//					if (key.equals(item)) {
//						ItemServices.removePendingOffers(customers, item); // just use this instead of line below?
//						//currentCustomer.removeOffer(key); // this has to happen FIRST
//						// then you can alter the object
//						ItemServices.markItemAsOwned(item);
//						item.setSoldPrice(value);
//						currentCustomer.addOwnedItem(item);
//					}
//				}
//			}
//		}
		
		
//		ArrayList<Customer> customers = new ArrayList<Customer>();
//		for (Offer offer : offers) {
//			customers.add(offer.getCustomer());
//		}
		
		
		for (Offer offer : offers) {
			if (offer.getCustomer().equals(customerAccepted)) {
				
				
				//ItemServices.markItemAsOwned(item);
				item.setOwned(true);
				
				item.setSoldPrice(offer.getOfferAmount());
				
				customerAccepted.addOwnedItem(item);
				
//				Iterator i = offers.iterator();
//				offer = new Offer();
//				while(i.hasNext()) {
//					offer = (Offer) i.next();
//					if (offer.getItem().equals(item)) {
//						i.remove();
//					}
//				}
				
				ItemServices.removePendingOffers(offers, item);  // move this around ?
			}
		}
	}
	
	public void rejectOffer(/*ArrayList<Customer> customers,*/ Customer customerRejected, Item item, CopyOnWriteArrayList<Offer> offers) {

//		for (Customer currentCustomer : customers ) {
//			
//			if (currentCustomer.equals(customerRejected)) {
//				HashMap<Item, Double> offerItems = currentCustomer.getOfferItems();
//
//				for (Map.Entry mapElement : offerItems.entrySet()) {
//					Item key = (Item) mapElement.getKey();
//					Double value = (Double) mapElement.getValue();
//					if (key.equals(item)) {
//						currentCustomer.removeOffer(key);
//						// maybe remove offer from customer and add it to something like "owned items" ?
//					}
//				}
//			}
//		}
		
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		for (Offer offer : offers) {
			customers.add(offer.getCustomer());
		}
		
		for (Offer offer : offers) {
			if (offer.getCustomer().equals(customerRejected)) {
				
				offers.remove(offer);
				//customerRejected.removeOffer(item);
			}
		}
	}


	public void addItemToShop(ArrayList<Item> items, Item item) { 
		// TODO Auto-generated method stub
		items.add(item);
	}

	public void removeItemFromShop(ArrayList<Item> items, Item item) { 
		// TODO Auto-generated method stub
		items.remove(item);
	}


	public ArrayList<Double> viewAllPayments() { 
		// TODO Auto-generated method stub
		ArrayList<Double> payments = new ArrayList<Double>();
		return payments;

	}

	
}
