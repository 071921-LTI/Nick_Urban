package com.revature.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Item;

public class ConsoleMenus {

	static Scanner sc = new Scanner(System.in);


	public static void displyLoginOrSignUp() {
		
		String choice = "";

		do {
			System.out.println("select from the following options:");
			System.out.println("1: sign in \n2: sign up");
			choice = sc.nextLine();
			
			switch(choice) {
			case "1":
				System.out.println("sign in");
				login();
				
				break;
			case "2":
				//System.out.println("sign up");
				signUp();
				break;
			}
			
			
		} while (!choice.equals("1") && !choice.equals("2"));
		
		
		
		
		
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
		String userName = "";
		String pass = "";
		
		System.out.println("Please enter your username: ");
		userName = sc.nextLine();
		
		System.out.println("please enter you password: ");
		pass = sc.nextLine();
		
		System.out.println("LOGGED IN");
		
		
		
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
	

	public static void viewItems(ArrayList<Item> items) {
		
		for (Item item : items) {
			System.out.println(item);
		}
	} 
	
	public static void addItem(Item item) {
		
	}

}


