<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register Form:</h1>

	
	<form action="register" method="post">
		<label for="name">Name:</label>
		<input type="text" name="name" placeholder="Enter the name"> <br> <br>
		<label for="email">Email:</label>
		<input type="email" name="email" placeholder="Enter the Email"> <br> <br>
		<label for="message">Message:</label> <br>
		<textarea rows="5" cols="50" name="message"></textarea> <br> <br>
		<button type="submit" style="backgroud-color: green;">Submit</button>
	</form>
</body>
</html>