package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Exceptions.VehicleDekhoSystemException;
import com.model.Vehicle;
import com.service.VehicleDekhoService;

/**
 * Servlet implementation class ViewDetailUserController
 */
@WebServlet("/ViewDetailUserController")
public class ViewDetailUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetailUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * this method is used to get list of vehicles by using make and model from database and dispatch result to cardetails.jsp
	 * @param vehicles: holds vehicle list from database
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
		getServletContext().getRequestDispatcher("/cardetails.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
