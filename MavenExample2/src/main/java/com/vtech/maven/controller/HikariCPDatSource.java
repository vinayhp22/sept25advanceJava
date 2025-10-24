package com.vtech.maven.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDatSource {

	private static HikariDataSource ds;

	static {
		try {
			InputStream in = HikariCPDatSource.class.getClassLoader().getResourceAsStream("db.properties");
			Properties props = new Properties();

			if (in == null)
				throw new RuntimeException("db.properties not found in classpath");

			props.load(in);

			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(props.getProperty("db.url"));
			config.setUsername(props.getProperty("db.username"));
			config.setPassword(props.getProperty("db.password"));
			
			ds = new HikariDataSource(config);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static void main(String[] args) {
		try {
			Connection conn = HikariCPDatSource.getDataSource().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM test_table");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id") + " - "+resultSet.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
