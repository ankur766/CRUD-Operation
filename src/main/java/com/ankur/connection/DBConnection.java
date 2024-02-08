package com.ankur.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
	static Connection connection = null;
	Statement statement = null;
	static String url = "jdbc:mysql://zsql12.freesqldatabase.com:3306/vendor?serverTimezone=UTC";
	static String username = "sql12678085";
	static String password = "bP9matvAF3";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("connection was successful!");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

}
