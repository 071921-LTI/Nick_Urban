package com.revature.services;

import java.util.ArrayList;

import com.revature.exceptions.UserExistsException;
import com.revature.models.Customer;

public interface ICustomerServices {
	
	public void addCustomer() throws UserExistsException;
	
	public void deleteCustomer();
	
	public Customer getCustomer();
}
