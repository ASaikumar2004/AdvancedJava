<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Object sname1=pageContext.getAttribute("studentName",pageContext.PAGE_SCOPE);
Object city1=pageContext.getAttribute("studentCity",pageContext.SESSION_SCOPE);
Object course1=pageContext.getAttribute("studentCourse",pageContext.REQUEST_SCOPE);
Object college1=pageContext.getAttribute("collegeName",pageContext.APPLICATION_SCOPE);

%>

<h2>Student Name: <%=sname1 %></h2>
<h2>Student City: <%=city1 %></h2>
<h2>Student Course: <%=course1 %></h2>
<h2>College Name: <%=college1 %></h2>
</body>
</html>