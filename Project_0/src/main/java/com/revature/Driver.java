package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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
			System.out.println(con.getMetaData().getDriverName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Employee emp = new Employee("admin", "123", true);
		
		Customer cus1 = new Customer("bill", "123");
		Customer cus2 = new Customer("josh", "123");
		Customer cus3 = new Customer("stacey", "123");
		
		Item item1 = new Item(123, 20, 0, 0, 0, "basketball");
		Item item2 = new Item(456, 5, 0, 0, 0, "can of beans");
		Item item3 = new Item(789, 850, 0, 0, 0, "rare vinyl record");
		Item item321 = new Item(789, 850, 0, 0, 0, "rare vinyl record");
		
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		ItemServices.setItems(items);
		
		System.out.println(item1.toString());
		System.out.println(item3.equals(item1));
		System.out.println(item3.equals(item321));
		
		System.out.println();

		item1.addOffer(cus2, 40);
		item1.addOffer(cus3, 50);
		item2.addOffer(cus3, 15);
		
		
		
		System.out.println(item1.toString());
		System.out.println(cus2.toString());
		System.out.println(cus3.toString());
		
		System.out.println(cus2.getOfferItems());
		System.out.println(cus3.getOfferItems());
	}

}
