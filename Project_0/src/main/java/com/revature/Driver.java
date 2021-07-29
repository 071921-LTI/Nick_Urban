package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Item;
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
		
		Item item1 = new Item(123, 20, 0, 0, 0, "basketball");
		Item item2 = new Item(456, 5, 0, 0, 0, "guitar");
		Item item3 = new Item(789, 850, 0, 0, 0, "rare vinyl record");
		Item item321 = new Item(369, 32, 0, 0, 0, "bag of chips");
		
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers.add(cus1);
		customers.add(cus2);
		customers.add(cus3);

		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);

		item1.addOffer(cus2, 40);
		item1.addOffer(cus3, 50);
		item2.addOffer(cus3, 15);
		
		System.out.println();
		System.out.println();
		
		// shows that a customer has a list of owned items (that can be viewed)
		System.out.println(cus3.getOwnedItems());
		emp.acceptOffer(customers, cus3, item1);
		System.out.println(cus3.getOwnedItems());
		
		// shows that the system removes all offers on an item after it is sold
		//
//		System.out.println(cus3.getOfferItems());
//		System.out.println(cus2.getOfferItems());
//		emp.acceptOffer(customers, cus3, item1);
//		System.out.println(cus3.getOfferItems());
//		System.out.println(cus2.getOfferItems());
		
		
		// shows that employee can reject a customer offer
		//
//		System.out.println(cus2.getOfferItems());
//		emp.rejectOffer(customers, cus2, item1);
//		System.out.println(cus2.getOfferItems());
		

		
		
		// displays a customer making an offer and employee accepting offer
		// and item being removed from customers offer hash-set
		//
//		System.out.println(cus3.getOfferItems());
//		System.out.println(item1.toString());
//		emp.acceptOffer(customers, cus3, item1);
//		System.out.println("basketball sold");
//		System.out.println(cus3.getOfferItems());
//		System.out.println(item1.toString());
		
		// customer can make offer, then remove their offer
		//
//		cus3.makeOffer(item321, 0);
//		System.out.println(cus3.getOfferItems());
//		cus3.removeOffer(item321);
//		System.out.println(cus3.getOfferItems());
//		
		// not sure if this still works, probably not..
		//
//		cus3.removeOffer(item1);
//		System.out.println(cus3.getOfferItems());
		
		// shows that employee can add and remove items from "shop"
		//
//		System.out.println(items.toString());
//		emp.addItemToShop(items, item321);
//		System.out.println(items.toString());
//		emp.removeItemFromShop(items, item321);
//		System.out.println(items.toString());
	}

}
