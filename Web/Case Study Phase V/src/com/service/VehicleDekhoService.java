package com.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.Exceptions.VehicleDekhoSystemException;
import com.facade.VehicleDekhoFacade;
import com.factory.ConnectionFactory;
import com.model.Vehicle;

/**
 * this is service class which establish connection and after completing task closed that connection
 * this is call facade method and take arguments from controller
 * all methods are approximately same as facade methods
 * and difference is service create connection and pass it to facade as argument
 */
public class VehicleDekhoService {
	
	public boolean createVehicle(Vehicle vehicle) throws VehicleDekhoSystemException {
		boolean resultDB = false;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection(); 
			resultDB = facade.createVehicle(connection, vehicle);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not create vehicle due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		
		return resultDB;
	}
	
	public int updateVehicle(Vehicle vehicle) throws VehicleDekhoSystemException {
		int resultDB = 0;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.updateVehicle(connection, vehicle);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not Update vehicle due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}
	
	public List<String> getMake() throws VehicleDekhoSystemException {
		List<String> resultDB = null;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.getMake(connection);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not retrive list of make due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}
	
	public List<String> getModel(String make) throws VehicleDekhoSystemException {
		List<String> resultDB = null;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.getModel(connection, make);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not retrive list of model due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}
	
	public List<Vehicle> getVehicle(String make, String model) throws VehicleDekhoSystemException {
		List<Vehicle> resultDB = null;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.getVehicle(connection, make, model);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not retrive Vehicle due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}
	
	public int deleteVehicle(String make, String model) throws VehicleDekhoSystemException {
		int resultDB = 0;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection  = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.deleteVehicle(connection, make, model);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not delete Vehicle due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}
	
	public Map<String, String> getProfile() throws VehicleDekhoSystemException {
		Map<String, String> resultDB = null;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.getProfile(connection);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not get Admin Profile due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}
	
	public int updateProfile(List<String> profileData) throws VehicleDekhoSystemException {
		int resultDB = 0;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.updateProfile(connection, profileData);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not Update Admin Profile due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}
	
	public boolean isAdmin(String email, String password) throws VehicleDekhoSystemException {
		boolean resultDB = false;
		VehicleDekhoFacade facade = new VehicleDekhoFacade();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			resultDB = facade.isAdmin(connection, email, password);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n Could not validate admin due to : "+e.getMessage());
		} finally {
			if(connection != null ){
				ConnectionFactory.closeConnection(connection);
			}
		}
		return resultDB;
	}

}
