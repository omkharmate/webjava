package com.assignment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils  {
	private static Connection cn;
	private static String id="root";
	private static String pass="Pass@#123";
	private static String dbURL="jdbc:mysql://localhost:3306/assignment02";
	
	public static Connection getConnection() throws SQLException{
		cn=DriverManager.getConnection(dbURL,id,pass);
		return cn;
		
	}
	

}
