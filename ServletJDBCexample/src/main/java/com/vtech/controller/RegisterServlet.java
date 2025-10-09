package com.vtech.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.sendRedirect("register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
//		HttpSession session = request.getSession();
		
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =  DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO info(name, email, message) VALUES(?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, message);
			
			int rows =  stmt.executeUpdate();
			if(rows>0) {
//				response.sendRedirect("registerSuccess.jsp");
//				session.setAttribute("successMessage", "Successfully registered, Thanks - "+name);
				RequestDispatcher rd = request.getRequestDispatcher("registerSuccess.jsp");
				request.setAttribute("successMessage", "Successfully registered, Thanks - "+name);
				rd.forward(request, response);
			} else {
//				response.sendRedirect("registerError.jsp");
//				session.setAttribute("errorMessage", "There is an error to fill the form!!!");
				RequestDispatcher rd = request.getRequestDispatcher("registerError.jsp");
				request.setAttribute("errorMessage", "There is an error to fill the form!!!");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
//			response.sendRedirect("registerError.jsp");
//			session.setAttribute("errorMessage", "There is an error to fill the form!!!");
			RequestDispatcher rd = request.getRequestDispatcher("registerError.jsp");
			request.setAttribute("errorMessage", "There is an error to fill the form!!!");
			rd.forward(request, response);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
