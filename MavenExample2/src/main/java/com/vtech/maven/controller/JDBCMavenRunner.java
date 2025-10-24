package com.vtech.maven.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMavenRunner {

	public static void main(String[] args) {
		
		String sql = "INSERT INTO test_table VALUES(1, 'Varun')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "root");
		
			Statement stmt = conn.createStatement();
			
			int rows = stmt.executeUpdate(sql);
			
			if(rows>0) {
				System.out.println("Successfully inserted...");
			} else {
				System.err.println("Error Occurred...");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
