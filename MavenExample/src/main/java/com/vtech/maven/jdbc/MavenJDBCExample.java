package com.vtech.maven.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MavenJDBCExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "root");
			
			String sql = "INSERT INTO test_table VALUES(5, 'Virat')";
			
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate(sql);
			if(rows>0) {
				System.out.println("Successfully added");
			} else {
				System.out.println("Error occured");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
