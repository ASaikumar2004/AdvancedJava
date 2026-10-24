package com.UserRegistration.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	
	private static String url="jdbc:mysql://localhost:3306/userregistration";
	private static String username="root";
	private static String password="root";
	
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		return con;
	}

}
