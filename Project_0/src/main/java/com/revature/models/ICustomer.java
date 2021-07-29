package com.revature.models;

import java.util.ArrayList;

public interface ICustomer extends IUser {

	//public void makeOffer(Item item, double offer);
	
	public double makePayment(double payment);
	
	public ArrayList<Double> viewRemainingPayments();
	
}
