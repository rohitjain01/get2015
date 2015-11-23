package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 * This filter is used to authenticate the administrator
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
	private ServletContext context;
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }
    

    public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		 HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	         
	        String uri = req.getRequestURI();
	        this.context.log("Requested Resource::"+uri);
	         
	        HttpSession session = req.getSession();
	         
	        if(session.getAttribute("email") == null && (uri.endsWith("AdminHomeController") || uri.endsWith("AdminHome.jsp") || uri.endsWith("create.jsp") || uri.endsWith("CreateController") || uri.endsWith("editprofile.jsp") || uri.endsWith("EditProfileController") || uri.endsWith("searchAdmin.jsp") || uri.endsWith("SearchAdminController") || uri.endsWith("SearchAdminResult.jsp") || uri.endsWith("admincardetails.jsp") || uri.endsWith("ViewDetailController") || uri.endsWith("EditCarController") || uri.endsWith("editdetails.jsp"))){
	            this.context.log("Unauthorized access request");
	            res.sendRedirect("login.jsp?message=Please Login..");
	        }else{
	            // pass the request along the filter chain
	            chain.doFilter(request, response);
	        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	

}
