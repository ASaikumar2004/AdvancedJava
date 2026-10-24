<%@page import="cgjsp.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <%
Employee emp=new Employee();

emp.setEid(Integer.parseInt(request.getParameter("eid")));
emp.setEname(request.getParameter("ename"));
emp.setAge(Integer.parseInt(request.getParameter("eage")));

out.println(emp.getEid());
out.println(emp.getEname());
out.println(emp.getAge());
%> --%>

<h1>Employee details:</h1>

<jsp:useBean id="emp" class="cgjsp.Employee" scope="request" ></jsp:useBean>
<jsp:setProperty property="*" name="emp"/>
<%-- <jsp:setProperty property="ename" name="emp"/>
<jsp:setProperty property="age" name="emp"/> --%>

<h2>EmpId:<jsp:getProperty property="eid" name="emp"/></h2>
<h2>EmpName: <jsp:getProperty property="ename" name="emp"/></h2>
<h2>EmpAge: <jsp:getProperty property="age" name="emp"/></h2>

</body>
</html>