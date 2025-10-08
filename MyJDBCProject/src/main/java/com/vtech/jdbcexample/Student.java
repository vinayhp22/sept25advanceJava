package com.vtech.jdbcexample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class Student extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.sendRedirect("register.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String course = req.getParameter("course");
		
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "root";
		
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		try {
			//1. Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Create Connection
			Connection conn = DriverManager.getConnection(url, user, password);
			
			//3. Create SQL Statement
			String sql = "INSERT INTO student(name, email, course) VALUES(?, ?, ?)";
			
			//4. Create Prepared Statement
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, course);
			
			//5. Excection
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 0) {
				session.setAttribute("name", name);
				session.setAttribute("email", email);
				res.sendRedirect("registersuccess.jsp");
			} else {
				session.setAttribute("errorMessage", "Error in filling the form!!!. Try Again...");
				res.sendRedirect("register.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} 
	}

}
