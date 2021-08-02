package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import com.revature.daos.CustomerDao;
import com.revature.daos.CustomerPostgres;
import com.revature.daos.ItemDao;
import com.revature.daos.ItemPostgres;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Item;
import com.revature.models.Offer;

public class ConsoleMenus {

	static Scanner sc = new Scanner(System.in);

	static Customer customer = new Customer();
	static Employee employee = new Employee();
	static List<Item> availableItems = new ArrayList<Item>();
	//static ArrayList<Item> customerItems = new ArrayList<Item>();
	static CopyOnWriteArrayList<Offer> offers = new CopyOnWriteArrayList<Offer>();

	public static void displyLoginOrSignUp() {
		
		String choice = "";

		do {
			System.out.println("select from the following options:");
			System.out.println("1: sign in \n2: sign up");
			choice = sc.nextLine();
			
			switch(choice) {
			case "1":
				//System.out.println("sign in");
				login();
				
				break;
			case "2":
				//System.out.println("sign up");
				signUp();
				break;
			}
		} while (!choice.equals("1") && !choice.equals("2"));	
	}
	
	public static void customerMenu() {
		String choice = "";
		
		do {
			System.out.println("welcome " + ConsoleMenus.customer.getUserName() + ", what would you like to do?:");
			System.out.println("1: view available items\n2: view owned items\n3: sign out\n");
			choice = sc.nextLine();
			
			switch(choice) {
			case "1": 
				// view available items
				System.out.println("here are the available items:");
				viewAvailableItems();
				
				break;
			
			case "2": 
				//view owned items
				System.out.println("here are your owned items:");
				viewOwnedItems();
				
				break;
			case "3": 
				ConsoleMenus.customer = null;
				System.out.println("returning to login menu.");
				displyLoginOrSignUp();
				break;
			}
			
		} while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
	}
	
	public static void login() {
		String choice = "";
		
		
		do {
			System.out.println("Customer or Employee? \n1: Customer\n2: Employee");
			choice = sc.nextLine();
			
			switch (choice) {
			case "1":
				customerLogin();
				break;

			case "2":
				employeeLogin();
				break;
			}
			
		} while (!choice.equals("1") && !choice.equals("2"));
	}
	
	public static void customerLogin() {
		
		Customer cust = new Customer();
		String userName = "";
		String pass = "";
		
		System.out.println("Please enter your username: ");
		userName = sc.nextLine();
		
		System.out.println("please enter you password: ");
		pass = sc.nextLine();
		
		CustomerDao cp = new CustomerPostgres();
		
		cust = cp.getCustomerByUserName(userName);
		
		
		if ((cust != null && cust.getPassword().equals(pass))) {
			// bring them to the main menu
			ConsoleMenus.customer = cust;
			customerMenu();
		}
		else {
			System.out.println("incorrect username or password! returning to login page...");
			displyLoginOrSignUp();
		}
		
		
	}
	
	public static void employeeLogin() {
		String userName = "";
		String pass = "";
		
		System.out.println("Please enter your username: ");
		userName = sc.nextLine();
		
		System.out.println("please enter you password: ");
		pass = sc.nextLine();
		
		System.out.println("LOGGED IN");
		
		
		
	}
	
	public static void signUp() {
		String userName = "";
		String pass = "";
		
		
		System.out.println("Please enter your NEW username: ");
		userName = sc.nextLine();
		
		System.out.println("please enter a password: ");
		pass = sc.nextLine();
		sc.nextLine();
		
		System.out.println("USER CREATED");
	}
	

	public static void viewItems(List<Item> list) {
		
		int itemNum = 1;
		for (Item item : list) {
			
			System.out.println( itemNum + ": " + item.toString());
//			System.out.println("Id #: " + item.getId()
//								+ "description:" + item.getDescription()
//								+ );
		}
	} 
	
	public static void viewAvailableItems() {
		ItemDao ip = new ItemPostgres();
		ConsoleMenus.availableItems = ip.getAvailableItems();
		
		viewItems(ConsoleMenus.availableItems);
	}
	
	public static void viewOwnedItems() {
		ItemDao ip = new ItemPostgres();
		List<Item> custItems = new ArrayList<>();
		custItems = ip.getCustomerOwnedItems(ConsoleMenus.customer);
		viewItems(custItems);
	}
	
	public static void addItem(Item item) {
		
	}

}


