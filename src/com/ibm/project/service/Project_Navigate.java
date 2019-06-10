package com.ibm.project.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.project.dao.Fetch_login_details;

@WebServlet("/navigate")
public class Project_Navigate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
		String un=request.getParameter("tf1");
		String pass=request.getParameter("tf2");
		RequestDispatcher dispatcher=request.getRequestDispatcher("home.html");
		RequestDispatcher dispatcher1=request.getRequestDispatcher("signup.html");
		if(Fetch_login_details.validate_User(un,pass))
		{
			
			response.getWriter().println("<div style='background-color: red'>WELCOME</div>"+Fetch_login_details.logged_user());
			dispatcher.include(request, response);
		}
		else
		{
			response.getWriter().println("Sorry User does not exist,Pls Signup First.........");
		    dispatcher1.include(request,response);   
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
