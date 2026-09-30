package com.jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/jdbc";
		String user="root";
		String password="root";
		Connection conn=DriverManager.getConnection(url, user, password);
		
		String sql="select * from dept";
		PreparedStatement ps=conn.prepareStatement(sql);
		
	    ResultSet rs= ps.executeQuery();
	    
	    System.out.println("DId"+" "+"Dname");
	    while(rs.next()) {
	    	System.out.print(rs.getInt("did")+" "+rs.getString("dname"));
	    	System.out.println();
	    }
	    
		
	    ps.close();
	    conn.close();
	
		
	}
}
