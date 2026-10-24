
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sms.model.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>
	<h2>Registered Students</h2>

	<table border="1" cellpadding="10">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
		</tr>

		<%
		List<Student> students = (List<Student>) request.getAttribute("students");

		if (students != null && !students.isEmpty()) {
			for (Student s : students) {
		%>
		<tr>
			<td><%=s.getSid()%></td>
			<td><%=s.getSname()%></td>
			<td><%=s.getEmail()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="3">No students found.</td>
		</tr>
		<%
		}
		%>
	</table>

	<br>
	<a href="register.jsp">Add Another Student</a>
	<br>
	<br>
	<a href="index.jsp">Home</a>
</body>
</html>
