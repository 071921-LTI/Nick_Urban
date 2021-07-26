package com.revature.models;

public class Employee implements IEmployee {

	public String userName = "";

	public String password = "";
	
	private boolean isEmployee = true;

	
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

	public void logIn() {
		// TODO Auto-generated method stub

	}

	public void viewItems() {
		// TODO Auto-generated method stub

	}

	public void addItemToShop() {
		// TODO Auto-generated method stub

	}

	public void removeItemFromShop() {
		// TODO Auto-generated method stub

	}

	public void considerOffer() {
		// TODO Auto-generated method stub

	}

	public void viewAllPayments() {
		// TODO Auto-generated method stub

	}

	

}
