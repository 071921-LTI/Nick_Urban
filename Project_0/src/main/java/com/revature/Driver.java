package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.services.IItemServices;
import com.revature.services.ItemServices;

public class Driver {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "password";
		
		try (Connection con = DriverManager.getConnection(url, username, password)){
			// shows if database is connected
			//System.out.println(con.getMetaData().getDriverName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Employee emp = new Employee("admin", "123", true);
		
		Customer cus1 = new Customer("bill", "123");
		Customer cus2 = new Customer("josh", "123");
		Customer cus3 = new Customer("stacey", "123");
		
		Item item1 = new Item(1, "basketball", 20, 0, 0, 0, 0, false);
		Item item2 = new Item(2, "guitar", 85, 0, 0, 0, 0, false);
		Item item3 = new Item(3, "rare vinyl record", 675, 0, 0, 0, 0, false);
		Item item321 = new Item(4, "bag of chips", 14, 0, 0, 0, 0, false);
		
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(cus1);
		customers.add(cus2);
		customers.add(cus3);

		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		
		CopyOnWriteArrayList<Offer> offers = new CopyOnWriteArrayList<Offer>(); 
//		offers.add(new Offer(cus3, item2, 90));
//		offers.add(new Offer(cus1, item3, 10));
//		offers.add(new Offer(cus1, item1, 40));
//		offers.add(new Offer(cus2, item1, 50));
		
		
		
		
		
		// shows that the system removes all offers on an item after it is sold
		//
//		offers.add(new Offer(cus3, item2, 90));
//		offers.add(new Offer(cus1, item3, 10));
//		offers.add(new Offer(cus1, item1, 40));
//		offers.add(new Offer(cus2, item1, 50));
//		System.out.println(offers);
//		emp.acceptOffer(cus2, item1, offers);
//		System.out.println();
//		System.out.println(offers);
		
		
		
		// shows that employee can reject a customer offer
		//
//		offers.add(new Offer(cus1, item1, 40));
//		offers.add(new Offer(cus2, item1, 50));
//		System.out.println(offers);
//		emp.rejectOffer(cus1, item1, offers);
//		System.out.println(offers);
				
				
		// displays a customer making an offer and employee accepting offer
		// and item being removed from offers list
		//
//		System.out.println(offers);
//		offers.add(new Offer(cus1, item3, 10));
//		System.out.println(offers);
//		emp.acceptOffer(cus1, item3, offers);
//		System.out.println(offers);
		
		
				
		// customer can make offer, then remove their offer
		//
//		System.out.println(offers);
//		offers.add(new Offer(cus1, item3, 10));
//		System.out.println(offers);	
//		cus1.rejectOffer(item3, offers);
//		System.out.println(offers);
		
		

			
		
		
		// shows that employee can add and remove items from "shop"
		//
		System.out.println(items);
		emp.addItemToShop(items, item321);
		System.out.println(items);
		emp.removeItemFromShop(items, item321);
		System.out.println(items);
		
		
		
		
		
		
		
		
		
		
		
//		item1.addOffer(cus2, 40);
//		item1.addOffer(cus3, 50);
//		item2.addOffer(cus3, 15);
		
		
	
	}
	
	public static void removeFromArrayList(List<Offer> offers, Item item) {
		//System.out.println(offers);
		Iterator i = offers.iterator();
		Offer offer = new Offer();
		while(i.hasNext()) {
			offer = (Offer) i.next();
			if (offer.getItem().equals(item)) {
				i.remove();
			}
		}
		//System.out.println(offers);
		
		
	}

}
