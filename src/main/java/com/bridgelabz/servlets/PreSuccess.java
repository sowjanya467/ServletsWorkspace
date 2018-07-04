package com.bridgelabz.servlets;
/*************************************************************************************************************
*
* purpose:Servlet for wesuccessful login
* @author sowjanya467
* @version 1.0
*  @since 4-05-18
*
* **************************************************************************************************/

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PreSuccess extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher = req.getRequestDispatcher("successlogin.jsp");
		dispatcher.forward(req, resp);
	}

}