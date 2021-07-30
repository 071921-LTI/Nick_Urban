package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection con;
	
	public static Connection getHardCodedConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "password";
		/*
		 * return a connection if one exist (static Connection con), else create one
		 */
		if(con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, username, password);
		} 
		
		return con;
	}
}
