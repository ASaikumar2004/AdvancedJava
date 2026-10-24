<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Example</title>
</head>
<body>

<%
String name=request.getParameter("name");
int age=Integer.parseInt(request.getParameter("age"));

if(age>18)
{
%>
<h1>Eligible to vote</h1>
<h2>name:<%=name%></h2>
<h2>age:<%=age %></h2>

<%
}
else{
	throw new Exception("Sorry "+name+",you are not eligible.Age must be 18 or above.");
}
%>

<%-- <%
int a=10,b=0;
int result=a/b;
%>

<h1>Result:<%=result%></h1>
 --%>
</body>
</html>