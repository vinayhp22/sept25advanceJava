package com.vtech.maven.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPDataSource {

	private static BasicDataSource ds;
	
	static {
		try {
		InputStream in = DBCPDataSource.class.getClassLoader().getResourceAsStream("db.properties");
		Properties props = new Properties();
		
		if(in == null) {
			throw new RuntimeException("db.properties not found in classpath");
		}
		
			props.load(in);
			String driver = props.getProperty("db.driverClassName");
			String url = props.getProperty("db.url");
			String username = props.getProperty("db.username");
			String password = props.getProperty("db.password");
			
			ds = new BasicDataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return ds;
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = DBCPDataSource.getDataSource().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM test_table");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " - "+resultSet.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
