package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomePage extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException 
	{
		String name = (String) req.getAttribute("user_name");
		String gmail = (String) req.getAttribute("email_id");
		String password = (String) req.getAttribute("password");
		String mobile = (String) req.getAttribute("mobile_num");

		PrintWriter out = resp.getWriter();
		out.println("" + name + " " + mobile);
		RequestDispatcher rs = req.getRequestDispatcher("WelcomePage");
		rs.forward(req, resp);

	}
}