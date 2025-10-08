<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Register Portal</h1>
	<%= session.getAttribute("message") %>
	<form action="register" method="post">
		<input type="text" name="name" placeholder="Enter the name"> <br> <br>
		<input type="email" name="email" placeholder="Enter the email"> <br> <br>
		<select name="course">
			<option value="">Select an Course</option> 
			<option value="Java">Java</option>
			<option value="Python">Python</option>
		</select>
		<input type="submit" value="Register">
	</form>
</body>
</html>