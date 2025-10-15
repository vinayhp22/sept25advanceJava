package com.vtech.hbms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtech.hbms.util.DBUtil;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		String sql = "SELECT * FROM patient where id = ?";
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id = Integer.parseInt(req.getParameter("id"));
		 
		 
		 String sql = "Update patient SET status = ?, admittedDate = ?, dischargeDate = ? WHERE id = ?";
		 try(Connection con = new DBUtil().getConnection();
			 PreparedStatement stmt = con.prepareStatement(sql)) {
			 
			 
		} catch (ClassNotFoundException | SQLException e) {
			
		}
	}
	
}
