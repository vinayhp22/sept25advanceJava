<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% HttpSession s = request.getSession(false); 
	if(s==null || session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}
%>
	<h1>Home page</h1>
	<p> ${registerSuccessMessage}</p>
	<h3><%= request.getAttribute("updateSuccessMessage") %></h3>
	
	
	<a href="read">Patients List</a>
</body>
</html>