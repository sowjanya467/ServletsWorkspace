package com.bridgelabz.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PreLogin extends HttpServlet 
{
	
	private static final long serialVersionUID = -2288977288004099312L;
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		
		System.out.println("precontroller");
		req.getRequestDispatcher("registration.html").forward(req, resp);
	}
	protected void dopost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		doGet(req, resp);
	}
	

}
