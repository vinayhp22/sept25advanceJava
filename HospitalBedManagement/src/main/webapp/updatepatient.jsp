<%@page import="com.vtech.hbms.model.Patient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Form</h1>
	<% Patient patient =(Patient)request.getAttribute("patient"); %>
	<form action="update" method="post">
		<input type="hidden" name="id" value="<%= patient.getId() %>">
		Patient Name: <input type="text" name="patientname" readonly="readonly" value="<%= patient.getPatientName() %>">
		Patient Age: <input type="number" name="patientage" readonly="readonly" value="<%= patient.getPatientAge() %>">
		Address: <textarea rows="5" cols="50" name="patientaddress" readonly="readonly"><%= patient.getAddress() %></textarea>
		Registered date <input type="date" name="registeredtime"  readonly="readonly" value="<%= patient.getRegisteredTime() %>">
		<% java.sql.Date admittedDate = patient.getAdmittedDate();
	    String formattedAdmitDate = ""; // Initialize with empty string

	    if (admittedDate != null) {
	        // Use java.time.LocalDate for modern, clearer date handling
	        formattedAdmitDate = admittedDate.toLocalDate().toString();
	    } %>
		Admitted date: <input type="date" name="admitdate" value="<%= formattedAdmitDate %>>">
		Discharge Date: <input type="date" name="dischargedate" value="<%= patient.getDischargeDate()%>">
		Status: <select name="status"> 
					<option value="">Select one option</option>
					<option value="registered">Registered</option>
					<option value="admitted">Admitted</option>
					<option value="discharged">Discharged</option>
				</select>
		<input type="submit" value="Update">
	</form>
	
</body>
</html>