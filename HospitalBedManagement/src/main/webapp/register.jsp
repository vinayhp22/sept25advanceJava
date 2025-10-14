<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register form</h1>
	<form action="register" method="post">
		Patient Name: <input type="text" name="patientname">
		Patient Age: <input type="number" name="patientage">
		Address: <textarea rows="5" cols="50" name="patientaddress"></textarea>
		admitted date: <input type="date" name="admitdate">
		<input type="submit" value="Register">
	</form>
</body>
</html>