package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.Exceptions.VehicleDekhoSystemException;

/**
 * Factory class for Connection
 *
 */
public class ConnectionFactory {

	
	private static String DB_URL;
	private static String USER;
	private static String PASSWORD;
			
	private static Connection con = null;
	
	/**
	 * this method establish connection from database
	 * @param DB_URL: holds path of our database
	 * @param USER: holds user name of database
	 * @param PASSWORD: holds password database 
	 * @return connection object
	 * @throws VehicleDekhoSystemException
	 */
	public static Connection getConnection() throws VehicleDekhoSystemException{
		 
		DB_URL = "jdbc:mysql://localhost:3306/Vehicle_management"; // get URL
		
	    USER = "root"; // get USERNAME
		
		PASSWORD = "mysql";// get PASSWORD
		/* register driver */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new VehicleDekhoSystemException("Driver Class not found", e);
		}
		
		/* open connection */
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new VehicleDekhoSystemException("Error while make connection ", e);
		}
		return con;
	}
	
	/**
	 * this method is used to connection object
	 * @param connection: object of Connection
	 * @throws VehicleDekhoSystemException
	 */
	public static void closeConnection(Connection connection) throws VehicleDekhoSystemException {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Error while make connection ", e);
			}
		}
	}
	
}
