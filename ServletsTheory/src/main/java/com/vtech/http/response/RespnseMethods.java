package com.vtech.http.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class RespnseMethods extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1>HttpServletResponse Methods</h1>");

//		1. Setting Content Type
		out.println("<h1>1. Setting Content Type - setContentType(String)</h1>");
		resp.setContentType("text/html"); //HTML response
//		resp.setContentType("application/json"); //JSON response
		
//		2. Writing output to the client - getWriter()
		out.println("<h1>2. Writing output to the client - getWriter()</h1>");
		PrintWriter writer = resp.getWriter();
		writer.println("<p>Writing these from resp.getWriter() </p>");
		
//		3. Redirecting - sendRedirect(String)
		out.println("<h1>3. Redirecting - sendRedirect(String)</h1>");
//		resp.sendRedirect("welcome.jsp"); //client-side redirect
		
//		4. Setting Headers
		out.println("<h1>4. Setting Headers - setHeader(String, String)</h1>");
		resp.setHeader("name", "Vinay");
		resp.setHeader("institute", "vtech");
		resp.setHeader("cache-control", "no-cache");
		

	}
}
