package com.revature.models;

public class Customer implements ICustomer {
	
	public String userName = "";
	
	public String password = "";
	
	private boolean isEmployee = false;

	
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

	public void makeOffer() {
		// TODO Auto-generated method stub
		
	}

	public void registerAccount() {
		// TODO Auto-generated method stub
		
	}

	public void viewItems() {
		// TODO Auto-generated method stub
		
	}

	public void viewRemainingPayments() {
		// TODO Auto-generated method stub
		
	}


}
