package com.vtech.hbms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class PatientsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root","root");
			
			String sql = "SELECT * FROM patients";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String patientName = resultSet.getString("patientname");
				int age = resultSet.getInt("patientAge");
				String patientAddress = resultSet.getString("patientaddress");
				Timestamp admitdate = resultSet.getTimestamp("admitdate");
				System.out.println("id"+id+", patientname"+patientName+", patientaddress"+ patientAddress);
				System.out.println("Age: "+age);
				System.out.println("admitdate: "+admitdate);
			}
			
			conn.close();
			stmt.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
