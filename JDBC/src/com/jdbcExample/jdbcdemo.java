package com.jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcdemo {
	
	public static void main(String[] args) throws Exception{
		
		// step 1: to register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step 2: establish the  connection
		String url="jdbc:mysql://localhost:3306/jdbc";
		String username="root";
		String password="root";
		Connection con=DriverManager.getConnection(url,username,password);
		
		
		//step 3: create statement
		 Statement stmt=con.createStatement();
		 String sql="create table dept(did int, dname varchar(20))";
		
		 
		// execute query
		 stmt.execute(sql);
		 
		System.out.println("table created successfully");
		
		//close all connections
		stmt.close();
		con.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
