package com.vtech.http.sessions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieservlet")
public class CookieExample extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. Create a cookie
		Cookie c = new Cookie("username", "admin");
		
		//2. Set max age
		c.setMaxAge(60*60); //1hour
		
		//3. Add cookie to response
		resp.addCookie(c);
		
		resp.sendRedirect("sessionexample.jsp");
	}

}
