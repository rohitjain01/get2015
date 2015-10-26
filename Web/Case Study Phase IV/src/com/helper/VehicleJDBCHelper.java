package com.helper;
/**
 * Case Study Phase II assignment
 * VehicleJDBCHelper.java
 * purpose : To perform operations on database
 * @author Rohit 
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.Utills.ConnectionUtill;
import com.model.Bike;
import com.model.Car;
import com.model.Vehicle;
import com.model.VehicleDekhoSystemException;

public class VehicleJDBCHelper {
	
	/** Method to insert vehicle data in database
	 * 
	 */
	@SuppressWarnings("resource")
	public static boolean create( Vehicle vehicle ) throws VehicleDekhoSystemException
	{
		/* Creating connection*/
		ConnectionUtill conUtil = new ConnectionUtill();
		Connection con = conUtil.getConnection();
		PreparedStatement prepareStmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean isInsert = false;
		try{
			/* take data from vehicle to corresponding variables*/
			String author = vehicle.getCreated_By();
			String make = vehicle.getMake();
			String model = vehicle.getModel();
			int engineCC = vehicle.getEnginInCC();
			int fuelCapacity = vehicle.getFuelCapacity();
			int milage = vehicle.getMilage();
			double price = vehicle.getPrice();
			double roadTax = vehicle.getRoadTax();
			// query for inserting data
			String query = "SELECT * FROM Vehicle WHERE make='"+make+"' AND model='"+model+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(!rs.next()) {
				isInsert = true;
				query = "INSERT INTO Vehicle(created_by,created_time,make,model,engine_cc,fuel_capacity,milage,price,roadTax) VALUES(?,?,?,?,?,?,?,?,?)";
				prepareStmt = con.prepareStatement(query); // make prepare statement object
				prepareStmt.setString(1, author);
				prepareStmt.setTimestamp(2, new Timestamp(vehicle.getCreated_Time().getTime()));
				prepareStmt.setString(3, make);
				prepareStmt.setString(4, model);
				prepareStmt.setInt(5, engineCC);
				prepareStmt.setInt(6, fuelCapacity);
				prepareStmt.setInt(7, milage);
				prepareStmt.setDouble(8, price);
				prepareStmt.setDouble(9, roadTax);
				prepareStmt.execute(); // execute query
				
				query = "SELECT vehicle_id FROM Vehicle ORDER BY vehicle_id DESC"; //take vehicle id for current inserting data
				int vehicleId;
				
				rs = stmt.executeQuery(query);
				rs.next();
				vehicleId = rs.getInt(1);
				if(vehicle instanceof Car) // check if vehicle is instance of car than entry do in car table
				{
					String ac = "NO", powerSteering = "NO", accessoryKit = "NO";
					if(((Car)vehicle).isAC())
					{
						ac = "YES";
					}
					if(((Car)vehicle).isPowerSteering())
					{
						powerSteering = "YES";
					}
					if(((Car)vehicle).isAccessoryKit())
					{
						accessoryKit = "YES";
					}
					query = "INSERT INTO Car(ac,powersteering,accessorykit,vehicle_id) VALUES(?,?,?,?)"; // query for inserting data in car table
					prepareStmt = con.prepareStatement(query);
					prepareStmt.setString(1, ac);
					prepareStmt.setString(2, powerSteering);
					prepareStmt.setString(3, accessoryKit);
					prepareStmt.setInt(4, vehicleId);
					prepareStmt.execute();			// execute query
				}
				else				// otherwise do in bike table
				{
					String selfStart = "NO";
					double helmetprice = ((Bike)vehicle).getHelmetPrize();
					if(((Bike)vehicle).isSelfStart())
					{
						selfStart = "YES";
					}
					query = "INSERT INTO Bike(selfstart,helmetprice,vehicle_id) VALUES(?,?,?)"; // query for inserting data in Bike table
					prepareStmt = con.prepareStatement(query);
					prepareStmt.setString(1, selfStart);
					prepareStmt.setDouble(2, helmetprice);
					prepareStmt.setInt(3, vehicleId);
					prepareStmt.execute();
				}
			}
			con.commit();
		}
		catch (SQLException e) {
			try{
				con.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new VehicleDekhoSystemException("Could not insert due to : "+e.getMessage());
		}
		finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(prepareStmt != null){
					prepareStmt.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return isInsert;
	}
	
	/* Method to search vehicles in database*/
	@SuppressWarnings("resource")
	public static List<Vehicle> searchByMakeAndModel(String make, String model) throws VehicleDekhoSystemException {
		String query = "SELECT * FROM vehicle WHERE make = '"+make+"' AND model = '"+model+"'"; // query for search
		Statement stmt = null, stmt2 = null;
		ResultSet rsVehicle = null;
		ResultSet rsSpecific = null;
		String selfStart = "", ac, powerSteering, accessoryKit, createdBy;
		int engineCC, fuelCapacity, mileage;
		Date createdTime;
		double price, roadTax, helmetPrice= 0;
		ConnectionUtill conUtil = new ConnectionUtill();
		Connection con = conUtil.getConnection();
		List<Vehicle> vehicles = null;
		try {
			stmt = con.createStatement();
			stmt2 = con.createStatement();
			rsVehicle = stmt.executeQuery(query); // execute the query and take data in resultset
			vehicles = new ArrayList<Vehicle>(); // make a list which holds results
			Vehicle vehicle = null;
			while(rsVehicle.next()) {
				// put data from result set to corresponding variables
				createdBy = rsVehicle.getString("created_by");
				createdTime = rsVehicle.getDate("created_time");
				model = rsVehicle.getString("model");
				engineCC = rsVehicle.getInt("engine_cc");
				fuelCapacity = rsVehicle.getInt("fuel_capacity");
				mileage = rsVehicle.getInt("milage");
				price = rsVehicle.getDouble("price");
				roadTax = rsVehicle.getDouble("roadTax");
				
				int vehicle_id = rsVehicle.getInt("vehicle_id");
				
				query = "SELECT * FROM Car WHERE vehicle_id = "+vehicle_id;
				
				rsSpecific = stmt2.executeQuery(query);
				
				if(rsSpecific.next() == false) {// if vehicle is not a car than it will be bike
					query = "SELECT * FROM Bike WHERE vehicle_id = "+vehicle_id;
					rsSpecific = stmt2.executeQuery(query);
					if(rsSpecific.next()) {
						vehicle = new Bike();
						boolean b1 = false;
						selfStart = rsSpecific.getString("selfstart");
						helmetPrice = rsSpecific.getDouble("helmetprice");
						if( selfStart.equals("YES") )
							b1 = true;;
						((Bike)vehicle).setSelfStart(b1);
						((Bike)vehicle).setHelmetPrize(helmetPrice);
					}
				}
				else {// otherwise it is a car than put specific attributes of car in vehicle
					vehicle = new Car();
					boolean b1 = false, b2 = false, b3 = false;
					ac = rsSpecific.getString("ac");
					powerSteering = rsSpecific.getString("powersteering");
					accessoryKit = rsSpecific.getString("accessorykit");
					if( ac.equals("YES") ) b1 = true;
					if( powerSteering.equals("YES") ) b2 = true;
					if( accessoryKit.equals("YES") ) b3 = true;
					((Car)vehicle).setAC(b1);
					((Car)vehicle).setPowerSteering(b2);
					((Car)vehicle).setAccessoryKit(b3);
				}
				// set all the attributes of vehicle
				vehicle.setCreated_By(createdBy);
				vehicle.setCreated_Time(createdTime);
				vehicle.setEnginInCC(engineCC);
				vehicle.setFuelCapacity(fuelCapacity);
				vehicle.setMake(make);
				vehicle.setMilage(mileage);
				vehicle.setModel(model);
				vehicle.setPrice(price);
				vehicle.setRoadTax(roadTax);
				vehicles.add(vehicle);				// add vehicle object in a list
			}
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not search due to : "+e.getMessage());
		}
		finally {
			try {
				if(stmt != null)
					stmt.close();
				if(stmt2 != null)
					stmt2.close();
				if(rsSpecific != null)
					rsSpecific.close();
				if(rsVehicle != null)
					rsVehicle.close();
			} catch(Exception e) {
				throw new VehicleDekhoSystemException("Could not close due to : "+e.getMessage());
			}
		}
		return vehicles;	// return the list
	}
	 /* method used for delete data from database based on make*/
	public static int deleteByMake(String make) throws VehicleDekhoSystemException {
		String query = "DELETE FROM Vehicle where make = '"+make+"'";
		ConnectionUtill conUtil = new ConnectionUtill();
		Connection con = conUtil.getConnection();
		int numberOfrecordsDeleted = 0;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			numberOfrecordsDeleted = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return numberOfrecordsDeleted;
	}
	
	/* method used for delete data from database based on model*/
	public static int deleteByModel(String model) throws VehicleDekhoSystemException {
		String query = "DELETE FROM Vehicle where model = '"+model+"'";
		ConnectionUtill conUtil = new ConnectionUtill();
		Connection con = conUtil.getConnection();
		int numberOfrecordsDeleted = 0;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			numberOfrecordsDeleted = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return numberOfrecordsDeleted;
	}
	
	/* method used for delete data from database based on make and model*/
	public static int deleteByMakeModel(String make, String model) throws VehicleDekhoSystemException {
		String query = "DELETE FROM Vehicle WHERE make = '"+make+"' AND model = '"+model+"'";
		ConnectionUtill conUtil = new ConnectionUtill();
		Connection con = conUtil.getConnection();
		int numberOfrecordsDeleted = 0;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			numberOfrecordsDeleted = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return numberOfrecordsDeleted;
	}
	 /* method for update data in database*/
	public static int updateByMakeAndModel(Vehicle vehicle) throws VehicleDekhoSystemException {
		String query = "UPDATE Vehicle SET engine_cc="+vehicle.getEnginInCC()+",fuel_capacity="+vehicle.getFuelCapacity()+",milage="+vehicle.getMilage()+",price="+vehicle.getPrice()+",roadTax="+vehicle.getRoadTax()+" where make = '"+vehicle.getMake()+"' AND model='"+vehicle.getModel()+"'";
		ConnectionUtill conUtil = new ConnectionUtill();
		Connection con = conUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			int numberOfrecordsUpdated;
			numberOfrecordsUpdated = stmt.executeUpdate(query);
			query = "SELECT vehicle_id FROM Vehicle WHERE make='"+vehicle.getMake()+"' AND model='"+vehicle.getModel()+"'";
			rs = stmt.executeQuery(query);
			rs.next();
			int id = rs.getInt("vehicle_id");
			String ac = "NO", powerSteering = "NO", accessoryKit = "NO";
			if(((Car)vehicle).isAC())
			{
				ac = "YES";
			}
			if(((Car)vehicle).isPowerSteering())
			{
				powerSteering = "YES";
			}
			if(((Car)vehicle).isAccessoryKit())
			{
				accessoryKit = "YES";
			}
			query = "UPDATE Car SET ac='"+ac+"',powersteering='"+powerSteering+"',accessorykit='"+accessoryKit+"' WHERE vehicle_id="+id;
			stmt.executeUpdate(query);
			con.commit();
			return numberOfrecordsUpdated;
		} catch (SQLException e) {
			try{
				con.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(rs != null){
					rs.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
	}
	
	public static Map<String, String> adminProfile() throws VehicleDekhoSystemException {
		String query = "SELECT * FROM Admin";
		Connection con = null;
		ResultSet rs = null;
		ConnectionUtill conUtil = new ConnectionUtill();
		Statement stmt = null;
		Map<String, String> profile = new HashMap<String, String>();
		try {
			con = conUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			profile.put("email", rs.getString("email"));
			profile.put("name", rs.getString("name"));
			profile.put("password", rs.getString("password"));
			profile.put("contact", rs.getString("contact"));
			profile.put("address", rs.getString("address"));
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return profile;
	}
	
	public static List<String> distictMake() throws VehicleDekhoSystemException {
		String query = "SELECT DISTINCT make from Vehicle";
		Connection con = null;
		ResultSet rs = null;
		ConnectionUtill conUtil = new ConnectionUtill();
		Statement stmt = null;
		List<String> make = new ArrayList<String>();
		try {
			con = conUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				make.add(rs.getString("make"));
			}
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(rs != null){
					rs.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return make;
	}
	
	public static List<String> searchModel(String make) throws VehicleDekhoSystemException {
		String query = "SELECT model from Vehicle WHERE make='"+make+"'";
		Connection con = null;
		ResultSet rs = null;
		ConnectionUtill conUtil = new ConnectionUtill();
		Statement stmt = null;
		List<String> model = new ArrayList<String>();
		try {
			con = conUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				model.add(rs.getString("model"));
			}
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return model;
	}
	
	public static int updateAdminProfile(HttpServletRequest request) throws VehicleDekhoSystemException {
		String query = "UPDATE Admin SET email='"+request.getParameter("email")+"', name='"+request.getParameter("name")+"', password='"+request.getParameter("password")+"', contact='"+request.getParameter("contact")+"', address='"+request.getParameter("address")+"'";
		Connection con = null;
		Statement stmt = null;
		ConnectionUtill conUtil = new ConnectionUtill();
		con = conUtil.getConnection();
		int update = 0;
		try{
			stmt = con.createStatement();
			update = stmt.executeUpdate(query);
			con.commit();
		} catch (SQLException e) {
			try{
				con.rollback();
			} catch(SQLException e1) {
				throw new VehicleDekhoSystemException("Could not roll back : "+e1.getMessage());
			}
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return update;
	}
	
	public static boolean loginCheck(HttpServletRequest request) throws VehicleDekhoSystemException {
		boolean isAdmin = false;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String query = "SELECT * FROM Admin WHERE email='"+email+"' AND password='"+password+"'";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		ConnectionUtill conUtil = new ConnectionUtill();
		con = conUtil.getConnection();
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if( rs.next() ) {
					isAdmin = true;
			}
		} catch (SQLException e) {
			throw new VehicleDekhoSystemException("Could not delete due to : "+e.getMessage());
		} finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(rs != null){
					rs.close();
				}
				con.close();
			} catch (SQLException e) {
				throw new VehicleDekhoSystemException("Could not closed due to : "+e.getMessage());
			}
			
		}
		return isAdmin;
	}
}
