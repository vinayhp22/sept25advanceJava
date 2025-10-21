package com.vtech.hbms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vtech.hbms.util.DBUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		boolean validation = validate(username, password);
		if(validation==true) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			resp.sendRedirect("index.jsp");
		} else {
			req.setAttribute("loginerror", "Invalid usn & pwd!!!!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
	
	private boolean validate(String username, String password) {
		
		String sql = "Select * from users where username = ? AND password = ?";
		
		
		try {
			Connection connection = new DBUtil().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				return true;
			} else {
				return false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
