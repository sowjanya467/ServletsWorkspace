package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PreLogin extends HttpServlet 
{

	private static final long serialVersionUID = -2288977288004099312L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();

		System.out.println("precontroller");
		out.println("<html><body><h2>You are not registered</h2></body></html>");

		req.getRequestDispatcher("prelogin.html").forward(req, resp);
	}

	protected void dopost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doGet(req, resp);
	}

}
