package com.ibm.project.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.project.dao.Fetch_login_details;

/**
 * Servlet implementation class Signedup
 */
@WebServlet("/sign")
public class Signedup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        Fetch_login_details.create_User(request.getParameter("name"),
	    		request.getParameter("id"),
	    		request.getParameter("email"),
	    		request.getParameter("contact"),
	    		request.getParameter("pass"));
	         response.getWriter().println("You are Successfully Registered,Pls Login to Proceed Further.........");
	         request.getRequestDispatcher("login.html").include(request, response);
    	
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
