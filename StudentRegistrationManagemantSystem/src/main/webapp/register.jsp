
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Student</title>
</head>
<body>
	<h2>Register Student</h2>

	<form action="${pageContext.request.contextPath}/StudentServlet"
      method="post">
		<input type="hidden" name="action" value="add">
		<label>StudentName:</label> 
		<input type="text" name="sname" required> 
		<br><br> 
		<label>Email:</label> 
		<input type="email" name="email" required> 
		<br><br>
		<button type="submit">Add Student</button>
	</form>

	<br>
	<a href="index.jsp">Home</a>
</body>
</html>
