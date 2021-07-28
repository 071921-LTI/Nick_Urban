package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Item;

public class ItemServices implements IItemServices {
	
	public static ArrayList<Item> items;
	
	
	public static ArrayList<Item> getItems() {
		return items;
	}

	public static void setItems(ArrayList<Item> items) {
		ItemServices.items = items;
	}

	public static void markItemAsOwned(Item item) {
		// TODO Auto-generated method stub
		
	}

	public static void calculateWeeklyPayment(Item item) {
		// TODO Auto-generated method stub
		
	}

	public static void updateRemainingPayment(Item item) {
		// TODO Auto-generated method stub
		
	}

	public static void addItem(Item item) {
		// TODO Auto-generated method stub
		ItemServices.items.add(item);
		
	}

	public static void removeItem(Item item) {
		// TODO Auto-generated method stub
		ItemServices.items.remove(item);
	}
}
