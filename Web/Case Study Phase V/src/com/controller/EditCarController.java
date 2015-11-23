package com.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Car;
import com.model.Vehicle;
import com.service.VehicleDekhoService;
import com.Exceptions.VehicleDekhoSystemException;

/**
 * Servlet implementation class EditCarController
 * This is controller for Edit car request
 */
@WebServlet("/EditCarController")
public class EditCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * this method take parameters make & model from request and getList of vehicles from database and dispatch result to editdetails.jsp
	 * @param vehicles: hold list of vehicles return by database
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		VehicleDekhoService service = new VehicleDekhoService();
		try {
			List<Vehicle> vehicles = service.getVehicle(make, model);
			request.setAttribute("vehicles", vehicles);
		} catch (VehicleDekhoSystemException e) {
			System.out.println(e.getMessage());
		}
		getServletContext().getRequestDispatcher("/editdetails.jsp").forward(request, response);
	}

	/**
	 * this method is update or delete vehicle from database
	 * as per the request of user it updates the parameters of vehicle or delete the vehicle and dispatch request to AdminHome.jsp
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vehicle vehicle = updateCar(request);
		VehicleDekhoService service = new VehicleDekhoService();
		if(request.getParameter("type").equals("Update")) {
			try {
				service.updateVehicle(vehicle);
			} catch (VehicleDekhoSystemException e) {
				// TODO Auto-generated catch block
				System.out.println("\n Can't update due to : "+e.getMessage());
			}
			
		} else {
			try {
				service.deleteVehicle(request.getParameter("make"), request.getParameter("model"));
			} catch (VehicleDekhoSystemException e) {
				// TODO Auto-generated catch block
				System.out.println("\n can't delete due to : "+e.getMessage());
			}
		}
		getServletContext().getRequestDispatcher("/AdminHomeController").forward(request, response);
	}
	
	/**
	 * this method just create Vehicle by using setters method 
	 * @param request: holds vehicle attributes
	 * @return Vehicle object
	 */
	private Vehicle updateCar(HttpServletRequest request) {
		Vehicle vehicle = new Car();
		vehicle.setCreated_By(request.getParameter("name"));
		vehicle.setCreated_Time(Calendar.getInstance().getTime());
		vehicle.setEnginInCC(Integer.parseInt(request.getParameter("enginecc")));
		vehicle.setFuelCapacity(Integer.parseInt(request.getParameter("fuelcapacity")));
		vehicle.setMake(request.getParameter("make"));
		vehicle.setMilage(Integer.parseInt(request.getParameter("milage")));
		vehicle.setModel(request.getParameter("model"));
		vehicle.setPrice(Double.parseDouble(request.getParameter("price")));
		Double roadTax = (Double.parseDouble(request.getParameter("price")))/10.0;
		vehicle.setRoadTax(roadTax);
		((Car) vehicle).setAC(false);
		((Car) vehicle).setAccessoryKit(false);
		((Car) vehicle).setPowerSteering(false);
		if(request.getParameter("ac").equals("yes")) {
			((Car) vehicle).setAC(true);
		}
		if(request.getParameter("accessorykit").equals("yes")) {
			((Car) vehicle).setAccessoryKit(true);
		}
		if(request.getParameter("powersteering").equals("yes")) {
			((Car) vehicle).setPowerSteering(true);
		}
		return vehicle;
	}

}
