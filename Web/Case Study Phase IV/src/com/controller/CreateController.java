package com.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.VehicleJDBCHelper;
import com.model.Car;
import com.model.Vehicle;
import com.model.VehicleDekhoSystemException;

/**
 * Servlet implementation class CreateController
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vehicle vehicle = createCar(request);
		try {
			if(VehicleJDBCHelper.create(vehicle)){
				request.setAttribute("message", "Car created Successfully");
			} else {
				request.setAttribute("message", "Car already exist.");
			}
		} catch (VehicleDekhoSystemException e) {
			// TODO Auto-generated catch block
			System.out.print("\n car can't created due to : "+e.getMessage());
		}
		getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
	}
	
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
