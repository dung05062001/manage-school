package com.mycompany.manage_school.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	public static Connection connectSqlServer() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connect = "jdbc:sqlserver://DESKTOP-R6Q5367\\SQLEXPRESS:1433;databaseName=managerstudent";
			String user = "websale";
			String pass = "dung11b4";
			connection = DriverManager.getConnection(connect, user, pass);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
