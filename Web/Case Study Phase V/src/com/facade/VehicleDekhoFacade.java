package com.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.Exceptions.VehicleDekhoSystemException;
import com.helper.VehicleJDBCHelper;
import com.model.Vehicle;

/**
 * this class implement facade design pattern
 * it is create a layer between data access object and java object 
 *
 */
public class VehicleDekhoFacade {
	
	 /**
	  * this method is used to create vehicle in database
	  * @param connection: connection object is passed to JDBC helper to access the data
	  * @param vehicle: A Vehicle object
	  * @return result that vehicle is insert or not 
	  * @throws VehicleDekhoSystemException
	  */
	public boolean createVehicle(Connection connection, Vehicle vehicle) throws VehicleDekhoSystemException {
		boolean resultDB = false;
		
		try {
			resultDB = VehicleJDBCHelper.create(connection, vehicle);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not create vehicle due to : "+e.getMessage());
		}
		
		return resultDB;
	}
	
	/**
	 * this method updates the vehicle attributes in database
	 * @param connection: connection object is passed to JDBC helper to access the data
	 * @param vehicle: A Vehicle object
	 * @return 1 for vehicle has updated and 0 for vehicle hasn't updated 
	 * @throws VehicleDekhoSystemException
	 */
	public int updateVehicle(Connection connection, Vehicle vehicle) throws VehicleDekhoSystemException {
		int resultDB = 0;
		try {
			resultDB = VehicleJDBCHelper.updateByMakeAndModel(connection,vehicle);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not Update vehicle due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	/**
	 * this method get list of all distinct makes from database 
	 * @param connection: connection object is passed to JDBC helper to access the data
	 * @return list of makes
	 * @throws VehicleDekhoSystemException
	 */
	public List<String> getMake(Connection connection) throws VehicleDekhoSystemException {
		List<String> resultDB = null;
		try {
			resultDB = VehicleJDBCHelper.distictMake(connection);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not retrive list of make due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	/**
	 * this methods get list of all models corresponding to make from database
	 * @param connection: connection object is passed to JDBC helper to access the data
	 * @param make: make attribute of vehicle
	 * @return list of models
	 * @throws VehicleDekhoSystemException
	 */
	public List<String> getModel(Connection connection, String make) throws VehicleDekhoSystemException {
		List<String> resultDB = null;
		try {
			resultDB = VehicleJDBCHelper.searchModel(connection, make);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not retrive list of model due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	/**
	 * this method get list of vehicles corresponding to make and model from database
	 * @param connection: connection object is passed to JDBC helper to access the data
	 * @param make: make attribute of vehicle
	 * @param model: model attribute of vehicle
	 * @return list of vehicles
	 * @throws VehicleDekhoSystemException
	 */
	public List<Vehicle> getVehicle(Connection connection, String make, String model) throws VehicleDekhoSystemException {
		List<Vehicle> resultDB = null;
		try {
			resultDB = VehicleJDBCHelper.searchByMakeAndModel(connection, make, model);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not retrive Vehicle due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	/**
	 * delete vehicle entry from database
	 * @param connection: connection object is passed to JDBC helper to access the data
	 * @param make: make attribute of vehicle
	 * @param model: model attribute of vehicle
	 * @return 1 if vehicle has deleted and 0 for vehicle is not deleted
	 * @throws VehicleDekhoSystemException
	 */
	public int deleteVehicle(Connection connection, String make, String model) throws VehicleDekhoSystemException {
		int resultDB = 0;
		try {
			resultDB = VehicleJDBCHelper.deleteByMakeModel(connection, make, model);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not delete Vehicle due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	/**
	 * get profile of administrator
	 * @param connection: connection object is passed to JDBC helper to access the data
	 * @return map of administrator profile
	 * @throws VehicleDekhoSystemException
	 */
	public Map<String, String> getProfile(Connection connection) throws VehicleDekhoSystemException {
		Map<String, String> resultDB = null;
		try {
			resultDB = VehicleJDBCHelper.adminProfile(connection);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not get Admin Profile due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	/**
	 * this method update profile of administrator
	 * @param connection: connection object is passed to JDBC helper to access the data
	 * @param profileData: holds list of profile data of administrator
	 * @return 0 if profile hasn't updated and 1 if profile has updated
	 * @throws VehicleDekhoSystemException
	 */
	public int updateProfile(Connection connection, List<String> profileData) throws VehicleDekhoSystemException {
		int resultDB = 0;
		try {
			resultDB = VehicleJDBCHelper.updateAdminProfile(connection, profileData);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not Update Admin Profile due to : "+e.getMessage());
		}
		return resultDB;
	}
	
	/**
	 * this method validate administrator email and password
	 * @param connection: connection object is passed to JDBC helper to access the data
	 * @param email: email which is entered by administrator
	 * @param password: password which is entered by password
	 * @return true if details are correct and false if details are wrong
	 * @throws VehicleDekhoSystemException
	 */
	public boolean isAdmin(Connection connection, String email, String password) throws VehicleDekhoSystemException {
		boolean resultDB = false;
		try {
			resultDB = VehicleJDBCHelper.loginCheck(connection, email, password);
		} catch (VehicleDekhoSystemException e) {
			try{
				connection.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			System.out.print("\n Could not validate admin due to : "+e.getMessage());
		}
		return resultDB;
	}

}
