<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   <%@ page import="java.util.Date" %> 
    <%!
    public String checkLength(String uname){
    	String res="";
    	if(uname.length()%2==0){
    		return "Even";
    	}
    	else{
    		return "odd";
    	}
    }
    
    %>
    
    <%
    String uname=request.getParameter("name");
    String department=request.getParameter("department");
    int salary=Integer.parseInt(request.getParameter("salary"));
    String res="";
    
    if(salary>10000){
    	res="High salary";			
    }
    else{
    	res="Low Salary";
    }
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>============Employee details=====</h1>
<h2>Employee name: <%=uname %></h2>
<h2>Employee Department: <%=department %></h2>
<h2>Salary: <%=salary %></h2>

<h1>============length checking=====</h1>

<h3>length checking is: <%=checkLength(uname) %></h3>

<h1>======== Scriptlet salary checking</h1>

<h3>salary:<%= res %></h3>


<h1>======== Curent date and time  during login </h1>

<h3>Date and Time:<%= new Date()%></h3>






</body>
</html>