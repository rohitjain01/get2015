package com.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Exceptions.VehicleDekhoSystemException;
import com.service.VehicleDekhoService;

/**
 * Servlet implementation class AdminHomeController
 * this is home page of admin
 */
@WebServlet("/AdminHomeController")
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeController() {
        super();
    }

	/**
	 * this method take administrator profile from database through VehicleDekhoservice
	 * and set profile as a request attribute
	 * and dispatch request to AdminHome.jsp
	 * @param profile: to hold profile data from database
	 * @param service: object of VechicleDekhoService by which get data from database 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map<String, String> profile;
		 VehicleDekhoService service = new VehicleDekhoService();
		try {
			profile = service.getProfile();
			request.setAttribute("profile", profile);
		} catch (VehicleDekhoSystemException e) {
			System.out.println("Can't fetch profile due to : "+e.getMessage());
		}
		getServletContext().getRequestDispatcher("/AdminHome.jsp").forward(request, response);
	}

	/**
	 * this method call doGet method
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
