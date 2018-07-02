package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		System.out.println("Printing from get");
		HttpSession session = req.getSession(false);
		if (session != null) {
			System.out.println("true");
			session.invalidate();
		}
		System.out.println("false");
		RequestDispatcher dispatch = req.getRequestDispatcher("PreSuccess");
		dispatch.forward(req, resp);
	}

}