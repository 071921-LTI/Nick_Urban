package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerPostgres implements CustomerDao {

	@Override
	public Customer getCustomerById(int id) {
		String sql = "select * from customers where id = ?;";
		Customer cust = null;
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int cId = rs.getInt("id");
				String userName = rs.getString("user_name");
				String pass = rs.getString("pass");
				boolean isEmployee = rs.getBoolean("is_employee");
				
				cust = new Customer(cId, userName, pass, isEmployee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cust;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			String sql = "select * from customers;";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String pass = rs.getString("pass");
				boolean isEmployee = rs.getBoolean("is_employee");
				
				Customer cust = new Customer(id, userName, pass, isEmployee);
				customers.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}

	@Override
	public int addCustomer(Customer customer) {
		int id = -1;
		String sql = "insert into customers (user_name, pass) values (?,?,?) returning id;";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, customer.getUserName());
			ps.setString(2, customer.getPassword());
			ps.setBoolean(3, false);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public int updateCustomerPassword(Customer customer, String pass) {
		int rowsChanged = -1;
		String sql = "update customers set pass = ? where id = ?;";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setInt(2, customer.getId());

			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsChanged;
	}

	@Override
	public int deleteCustomer(int id) {
		int rowsChanged = -1;
		String sql = "delete from customers where id = ?;";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsChanged;
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
