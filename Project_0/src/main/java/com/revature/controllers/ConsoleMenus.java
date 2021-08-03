package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import com.revature.daos.CustomerDao;
import com.revature.daos.CustomerPostgres;
import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeePostgres;
import com.revature.daos.ItemDao;
import com.revature.daos.ItemPostgres;
import com.revature.daos.OfferPostgres;
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
			System.out.println("1: view available items\n2: view owned items\n3: view your offers\n4: sign out\n");
			choice = sc.nextLine();
			
			switch(choice) {
			case "1": 
				// view available items and potentially make offer
				makeOffer();
				
				break;
			
			case "2": 
				//view owned items
				System.out.println("here are your owned items:");
				viewOwnedItems();
				
				break;
			case "3":
				System.out.println("here are your current offers:");
				viewMyOffers();
				break;
			case "4": 
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
		
		Employee emp = new Employee();
		String userName = "";
		String pass = "";
		
		System.out.println("Please enter your username: ");
		userName = sc.nextLine();
		
		System.out.println("please enter you password: ");
		pass = sc.nextLine();
		
		EmployeeDao ep = new EmployeePostgres();
		
		emp = ep.getEmployeeByUserName(userName);
		
		if (emp != null && emp.getPassword().equals(pass)) {
			ConsoleMenus.employee = emp;
			employeeMenu();
		}
		else {
			System.out.println("incorrect username or password! returning to login page...");
			displyLoginOrSignUp();
		}
	}
	
	public static void employeeMenu() {
		String choice = "";
		
		do {
			System.out.println("welcome (employee) " + ConsoleMenus.employee.getUserName() + ", what would you like to do?:");
			System.out.println("1: view available items\n2: add an item\n3: remove an item\n4: view offers\n5: view payments");
			choice = sc.nextLine();
			
			switch (choice) {
			case "1":
				viewAvailableItems();
				break;
			case "2":
				addItem();
				break;
			case "3":
				removeItem();
				break;
			case "4":
				viewAllOffers();
				break;
			case "5":
				
				break;
			}
			
			
		} while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5"));
	}
	
	public static void signUp() {
		String userName = "";
		String pass = "";
		
		CustomerPostgres cp = new CustomerPostgres();
		
		do {
			System.out.println("Please enter your NEW username: ");
			userName = sc.nextLine();
			
		} while(userName.isBlank());
		
		do {
			System.out.println("please enter a password: ");
			pass = sc.nextLine();
			
		} while (pass.isBlank());
		
		Customer cust = new Customer(userName, pass);
		
		cp.addCustomer(cust);
		
	}
	
	public static void viewItems(List<Item> list) {
		
		int itemNum = 1;
		for (Item item : list) {
			
			System.out.println( itemNum + ": " + item.toString());
			itemNum++;
			//			System.out.println("Id #: " + item.getId()
//								+ "description:" + item.getDescription()
//								+ );
		}
	} 
	
	public static void viewAvailableItems() {
		
		//System.out.println("in viewAvailableItems");
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
	
	public static void viewMyOffers() {
		OfferPostgres op = new OfferPostgres();
		
		
		List<Offer> custOfferList = op.getCustomerOffers(customer);
		
		if (!custOfferList.isEmpty()) {
			System.out.println(custOfferList);			
		}
		else {
			System.out.println("it looks like you haven't made any offers yet.");
		}
	}
	 
	public static void viewAllOffers() {
		OfferPostgres op = new OfferPostgres();
		List<Offer> offerList = op.getOffers();
		
		if(!offerList.isEmpty()) {
			System.out.println(offerList);
		}
		else {
			System.out.println("it looks like there are no offers.");
		}
		
	}
	
	public static void makeOffer() {
		int itemNum = 0;
		String customerChoice;
		
		do {
			System.out.println("here are the available items:");
			viewAvailableItems();
			System.out.println("select an item # to make an offer:");
			customerChoice = sc.nextLine();
			
		} while ((Integer.parseInt((customerChoice)) <= 0 && Integer.parseInt((customerChoice)) > ConsoleMenus.availableItems.size()));
		
		int parsedChoice = Integer.parseInt((customerChoice));
		Item offerItem = ConsoleMenus.availableItems.get(parsedChoice - 1);
		String offer;
		
		do {
			System.out.print("what is your offer?: $");
			offer = sc.nextLine();
			
		} while (Double.parseDouble(offer) < 0);
		
		double offerAmt = Double.parseDouble(offer);
		
		
		//System.out.println("offers before: " + offers);
		Offer newOffer = new Offer(ConsoleMenus.customer, offerItem, offerAmt);
		//offers.add(newOffer);
		//System.out.println("offers after: " + offers);
		OfferPostgres op = new OfferPostgres();
		op.addOffer(newOffer);
	}
	
	public static void addItem() {
		ItemPostgres ip = new ItemPostgres();
		String description = "";
		double price = 0;
		
		do {
			System.out.println("Provide a description:");	
			description = sc.nextLine();
		} while(description.isEmpty());
		
		do {
			System.out.println("provide a price:");
			price = sc.nextDouble();
		} while (price <= 0);
		
		Item newItem = new Item(description, price); 
		
		ip.addItem(newItem);
		ip.getAvailableItems();
		//System.out.println(newItem);
		
	}

	public static void removeItem() {
		int itemNum = 0;
		String employeeChoice;
		
		do {
			System.out.println("here are the available items:");
			viewAvailableItems();
			System.out.println("select an item # to remove it from the inventory:");
			employeeChoice = sc.nextLine();
			
		} while ((Integer.parseInt((employeeChoice)) <= 0 && Integer.parseInt((employeeChoice)) > ConsoleMenus.availableItems.size()));
		
		int parsedChoice = Integer.parseInt((employeeChoice));
		Item itemToBeRemoved = ConsoleMenus.availableItems.get(parsedChoice - 1);
		
		ItemPostgres ip = new ItemPostgres();
		
		ip.deleteItem(itemToBeRemoved.getId());
	}

}


