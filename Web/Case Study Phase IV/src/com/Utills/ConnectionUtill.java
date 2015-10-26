package com.Utills;
/**
 * Case Study Phase II assignment
 * ConnectionUtill.java
 * purpose : To establish connection from database
 * @author Rohit 
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtill {

	
	private String DB_URL;
	private String USER;
	private String PASSWORD;
			
	private Connection con = null;
	
	public Connection getConnection(){
		 
		DB_URL = "jdbc:mysql://localhost:3306/Vehicle_management"; // get URL
		
	    USER = "root"; // get USERNAME
		
		PASSWORD = "mysql";// get PASSWORD
		/* register driver */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* open connection */
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
