package com.vtech.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCRunner {
	public static void main(String[] args) {
		String name = "Ramesh";
		String email = "ramesh@gmail.com";
		String course = "Java";
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "root";
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
				System.out.println("Successfully registered!!!");
			} else {
				System.out.println("Error while registering!!!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

}
