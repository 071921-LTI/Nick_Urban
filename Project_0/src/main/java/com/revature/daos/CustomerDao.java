package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDao {
	public abstract Customer getCustomerById(int id);
	public abstract List<Customer> getCustomers();
	public abstract int addCustomer(Customer customer);
	public abstract int updateCustomerPassword(Customer customer, String pass);
	public abstract int deleteCustomer(int id);
	public abstract Customer getCustomerByUserName(String userName);
}
