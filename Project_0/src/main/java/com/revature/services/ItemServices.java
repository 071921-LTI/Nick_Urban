package com.revature.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.revature.models.Customer;
import com.revature.models.Item;

public class ItemServices implements IItemServices {
	
	public static void removePendingOffers(ArrayList<Customer> customers, Item item) {
		for (Customer customer : customers) {
			HashMap<Item, Double> offerItems = customer.getOfferItems();
			for (Map.Entry mapElement : offerItems.entrySet()) {
				Item key = (Item) mapElement.getKey();
				//Double value = (Double) mapElement.getValue(); // keep? remove?
				if (key.equals(item)) {
					customer.removeOffer(key);
				}
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
