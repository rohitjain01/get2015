package com.metacube.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.metacube.EmployeeSystemException;

/**
 * Class is used to create connection from database and closed it also.
 */
public class ConnectionFactory {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/Employee_management";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";
	private static Connection connection = null;
	
	/**
	 * to create connection from database 
	 * @return object of Connection
	 * @throws EmployeeSystemException
	 */
	public static Connection getConnection() throws EmployeeSystemException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load driver class, please add mysql jdbc driver to classpath.");
			throw new EmployeeSystemException("Could not load driver class, please add mysql jdbc driver to classpath.", e);
		} catch (SQLException e) {
			System.out.println("Coult not create connection with database, [" + e.getMessage() + "]");
			throw new EmployeeSystemException("Coult not create connection with database, [" + e.getMessage() + "]", e);
		}
		return connection;
	}
	
	/**
	 * method is used to closed the connection 
	 * @param connection: Connection object which is going to be closed
	 */
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Could not close connection due to following error, [" + e.getMessage() + "]");
			}
		}
	}
}
