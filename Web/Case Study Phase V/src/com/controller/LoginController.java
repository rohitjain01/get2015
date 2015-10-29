package com.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.VehicleDekhoService;
import com.Exceptions.VehicleDekhoSystemException;

/**
 * Servlet implementation class LoginController
 * Controller for login.jsp
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * dispatch request to login.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * this method validate login credentials
	 * check email and passwords from database and if correct than dispatch it  to AdminHomeController
	 * if if they are incorrect than dispatch to login.jsp
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		VehicleDekhoService service = new VehicleDekhoService();
		boolean isAdmin;
		try {
			isAdmin = service.isAdmin(email, password);
			RequestDispatcher loginunsuccessful = request.getRequestDispatcher("login.jsp");
			RequestDispatcher loginsuccessful = request.getRequestDispatcher("AdminHome.jsp");
			if( isAdmin == true ) {
					HttpSession session = request.getSession();
		            session.setAttribute("email", email);
		            Map<String, String> profile = service.getProfile();
		            request.setAttribute("profile", profile);
					loginsuccessful.forward(request, response);
			}
			else {
				request.setAttribute("message", "Either ID or Password is wrong..");
	            loginunsuccessful.forward(request, response);
			}
		} catch (VehicleDekhoSystemException e) {
			System.out.println("\n Could not validate user due to : "+e.getMessage());
		}
		
	}

}
