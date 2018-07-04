package com.bridgelabz.servlets;
/*************************************************************************************************************
*
* purpose:logout page using servlets
* @author sowjanya467
* @version 1.0
*  @since 4-05-18
*
* **************************************************************************************************/

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

		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		RequestDispatcher dispatch = req.getRequestDispatcher("logout.jsp");
		dispatch.forward(req, resp);
	}

}
