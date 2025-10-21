<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% HttpSession s =  request.getSession();
String name = (String)s.getAttribute("name"); 
String course = (String)s.getAttribute("course");
%>

<h1>Name: <%= name %></h1>
<h1>Course: <%= course %></h1>

<% Cookie[] c =  request.getCookies(); 
	if(c!= null){
		for(Cookie cookie : c){
			if(cookie.getName().equals("username")){
				String username = cookie.getValue(); %>
				<h1>From Cookies username = <%= username %></h1>
				<%
			}
		}
	}
%>





</body>
</html>