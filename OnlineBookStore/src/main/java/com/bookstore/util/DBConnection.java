package com.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String url="jdbc:mysql://localhost:3306/online_book_store";
	private static final String user="root";
	private static final String password="root";
	
	public static Connection getConnection() {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
			
			System.out.println("Database connected succesfully");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
