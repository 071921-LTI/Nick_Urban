package com.revature.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import com.revature.models.Customer;
import com.revature.models.Item;
import com.revature.models.Offer;

public class ItemServices implements IItemServices {
	
	//public static List<Offer> offers
	
	
	
	public static void removePendingOffers(CopyOnWriteArrayList<Offer> offers, Item item) { 
	//public static void removePendingOffers(List<Offer> offers, Item item) { // maybe try synchronized keyword ?
		
		//offers = new CopyOnWriteArrayList<Offer>();
		
		
		// iterator will NOT work
//		Iterator i = offers.iterator();
//		Offer offer = new Offer();
//		while(i.hasNext()) {
//			offer = (Offer) i.next();
//			if (offer.getItem().equals(item)) {
//				i.remove();
//			}
//		}
		
		for (Offer offer : offers) {
			if (offer.getItem().equals(item)) {
				offers.remove(offer);
			}
		}
	}

	
	public static void markItemAsOwned(Item item) {
		item.setOwned(true);
		
	}


	public void calculateWeeklyPayment(Customer customer, Item item, int weeks) {
		
		double weeklyPayments = 0;
		
		for (Item i : customer.getOwnedItems()) {
			if (i.equals(item) && item.getIsOwned()) {
				
				weeklyPayments = item.getSoldPrice() / weeks;
				item.setWeeklyPayments(weeklyPayments);
			}
		}
	}
}
