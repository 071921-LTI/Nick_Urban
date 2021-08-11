package com.nick.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection con;
	
	public static Connection getHardCodedConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	
	// use this eventually
//	public static Connection getConnectionFromEnv() throws SQLException {
//		
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		String url = System.getenv("DB_URL");
//		String username = System.getenv("DB_USER");
//		String password = System.getenv("DB_PASS");
//		
//		if(con == null || con.isClosed()) {
//			con = DriverManager.getConnection(url, username, password);
//		} 
//		
//		return con;
//	}
}
