package com.revature.models;

import java.util.ArrayList;

public interface IUser {

	public boolean logIn(String userName, String password);
	
	public boolean isEmployeeCheck();
	
	//public ArrayList<Item> viewItems();
}
