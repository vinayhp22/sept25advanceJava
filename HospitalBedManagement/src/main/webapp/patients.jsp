<%@page import="com.vtech.hbms.model.Patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Age</th>
		<th>Address</th>
		<th>Status</th>
		<th>Registered Date</th>
		<th>Admitted Date</th>
		<th>Discharge Date</th>
		<th>Actions</th>
	</tr>
	<% List<Patient> patients =  (List<Patient>)request.getAttribute("patients");
		for(Patient p : patients){ %>
		<tr>
			<td><%= p.getId() %></td>
			<td><%= p.getPatientName() %></td>
			<td><%= p.getPatientAge() %></td>
			<td><%= p.getAddress() %></td>
			<td><%= p.getStatus() %></td>
			<td><%= p.getRegisteredTime() %></td>
			<td><%= p.getAdmittedDate()%></td>
			<td><%= p.getDischargeDate() != null ?  p.getDischargeDate() : " "%></td>
			<td>
				<a href="update?id=<%= p.getId() %>">Edit</a>
				<a href="delete?id=<%= p.getId()%>">Delete</a>
			</td>
		</tr>
	<%	}
	%>
</table>
</body>
</html>