package com.tish.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private String url = "jdbc:sqlite:tish.db";
	
	private static Connection connect;
	
	DatabaseConnection() {
		try {
			connect = DriverManager.getConnection(url);
			System.out.println("succes");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance() {
		if (connect == null) {
			new DatabaseConnection();
		}
		return connect;
	}
}
