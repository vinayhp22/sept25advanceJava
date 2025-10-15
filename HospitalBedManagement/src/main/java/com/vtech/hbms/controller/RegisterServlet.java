package com.vtech.hbms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtech.hbms.util.DBUtil;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.sendRedirect("register.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String patientName = req.getParameter("patientname");
//		int patientId = 0;
		
		String patientAgeString = req.getParameter("patientage");
		int patientAge = Integer.parseInt(patientAgeString);
		String patientAddress = req.getParameter("patientaddress");
		String admitDateString = req.getParameter("admitdate");
		Date admitDate = Date.valueOf(LocalDate.parse(admitDateString));
		String dischargeDateStr = req.getParameter("dischargedate");
//		LocalDate dischargeDate = LocalDate.parse(dischargeDateStr);
		
		
		try {
			Connection conn = new DBUtil().getConnection();
			
			String sql = "INSERT INTO patients(patientname, patientage, patientaddress,admitdate, status, registeredtime) VALUES(?,?,?,?,?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, patientName);
//			patientId++;
//			stmt.setString(2, "HSPTL"+patientId);
			stmt.setInt(2, patientAge);
			stmt.setString(3, patientAddress);
			stmt.setDate(4, admitDate);
			stmt.setString(5, "registered");
			stmt.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
			
			int rows = stmt.executeUpdate();
			if(rows>0) {
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				req.setAttribute("registerSuccessMessage", "Successfully regiseted +"+patientName);
				rd.forward(req, res);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
				req.setAttribute("registerFailureMessage", "Not registered, please retry!!!");
				rd.forward(req, res);
			}
			
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
