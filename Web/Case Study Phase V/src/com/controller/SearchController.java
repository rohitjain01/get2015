package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Exceptions.VehicleDekhoSystemException;
import com.service.VehicleDekhoService;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * this method take list of all different makes from database and dispatch request to search.jsp
	 * @param make: to holds list of makes from database
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VehicleDekhoService service = new VehicleDekhoService();
		try {
			List<String> make = service.getMake();
			request.setAttribute("make", make);
		} catch (VehicleDekhoSystemException e) {
			System.out.println(e.getMessage());
		}
		getServletContext().getRequestDispatcher("/search.jsp").forward(request, response);
	}

	/**
	 * this method take request from searchAdmin and get list of all models from database and dispatch result to SearchResult.jsp
	 * @param model: holds list of model corresponding to make
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String make = request.getParameter("make");
		VehicleDekhoService service = new VehicleDekhoService();
		try {
			List<String> model = service.getModel(make);
			request.setAttribute("make", make);
			request.setAttribute("model", model);
		} catch (VehicleDekhoSystemException e) {
			System.out.println(e.getMessage());
		}
		getServletContext().getRequestDispatcher("/searchResult.jsp").forward(request, response);
	}

}
