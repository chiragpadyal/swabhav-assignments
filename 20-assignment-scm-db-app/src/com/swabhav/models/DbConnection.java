package com.swabhav.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// singleton db connection
public class DbConnection {
	private static Connection connection;

	private DbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scm", "root", "root");
			System.out.println("Successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setupConnect() {
		if(connection != null) System.out.println("Already Connected");
		new DbConnection();
	}

	public static Connection getConnection() {
		return connection;
	}
	
	public static void closeConnection() {
		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
