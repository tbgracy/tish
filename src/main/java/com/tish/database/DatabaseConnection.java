package com.tish.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private String url = "jdbc:sqlite:tish.db";
	
	private static Connection connect;
	
	DatabaseConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection(url);
		} catch (Exception e) {
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
