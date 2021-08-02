package com.revature.daos;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "select * from employees where id = ?;";
		Employee emp = null;

		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				int eId = rs.getInt("id");
				String userName = rs.getString("user_name");
				String pass = rs.getString("pass");
				boolean isEmployee = rs.getBoolean("is_employee");
				
				emp = new Employee(eId, userName, pass, isEmployee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();

		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			String sql = "select * from employees;";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("user_name");
				String pass = rs.getString("pass");
				boolean isEmployee = rs.getBoolean("is_employee");

				Employee emp = new Employee(id, userName, pass, isEmployee);
				employees.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public int addEmployee(Employee employee) {
		int id = -1;
		String sql = "insert into employees (user_name, pass, is_employee) values (?,?,?) returning id;";

		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getUserName());
			ps.setString(2, employee.getPassword());
			ps.setBoolean(3, true);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	@Override
	public int updateEmployeePassword(Employee employee, String pass) {
		int rowsChanged = -1;
		String sql = "update employees set pass = ? where id = ?;";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setInt(2, employee.getId());
			
			rowsChanged = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rowsChanged;
	}

	@Override
	public int deleteEmployee(int id) {
		int rowsChanged = -1;
		String sql = "delete from employees where id = ?;";

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
	public Employee getEmployeeByUserName(String userName) {
		String sql = "select * from employees where user_name = ?;";
		Employee emp = null;

		try (Connection con = ConnectionUtil.getHardCodedConnection()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				int eId = rs.getInt("id");
				String uName = rs.getString("user_name");
				String pass = rs.getString("pass");
				boolean isEmployee = rs.getBoolean("is_employee");
				
				emp = new Employee(eId, uName, pass, isEmployee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}
}
