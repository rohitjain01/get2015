package com.controller;

import java.io.IOException;
import java.util.Calendar;

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
 * Servlet implementation class CreateController
 * this is controller for create vehicle
 */
@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * this method just dispatch the request to create.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
	}

	/**
	 * this method put car data in database through VehicleDekhoService and dispatch result to create.jsp
	 * @param service: object of VehicleDekhoService is used to access database
	 * @param isCreated: holds result of that car is created or not
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vehicle vehicle = createCar(request); // call createCar method
		VehicleDekhoService service = new VehicleDekhoService();
		boolean isCreated = false;
		try {
			isCreated = service.createVehicle(vehicle);
		} catch (VehicleDekhoSystemException e) {
			System.out.print("\n car can't created due to : "+e.getMessage());
		}
		if(isCreated) {
			request.setAttribute("message", "Car created successfully");
		} else {
			request.setAttribute("message", "Car already exist");
		}
		getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
	}
	
	
	/**
	 * this method just create Vehicle by using setters method 
	 * @param request: holds vehicle attributes
	 * @return Vehicle object
	 */
	private Vehicle createCar(HttpServletRequest request){
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
