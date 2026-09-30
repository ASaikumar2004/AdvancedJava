package com.minibank.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	private static String url="jdbc:mysql://localhost:3306/minibank";
	private static String user="root";
	private static String password="root";
	
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		return conn;
	}
			
			

}
