package com.bridgelabz.servlets;
/*************************************************************************************************************
*
* purpose:Input validation for registration page using filters
* @author sowjanya467
* @version 1.0
*  @since 4-05-18
*
* **************************************************************************************************/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class RegisterFilter
 */
public class RegisterFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public RegisterFilter() {
		// TODO Auto-generated constructor stub
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		response.setContentType("text/html");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email_id");

		String mobile_num = request.getParameter("mobile_num");
		PrintWriter out = response.getWriter();
		if (user_name.equals("") || password.equals("")) {
			out.println("<center>username or password cant be empty</center>");
			RequestDispatcher dispatch = request.getRequestDispatcher("registration.html");
			dispatch.include(request, response);
		} else if (mobile_num.equals("") || email.equals("")) {
			out.println("<center>mobile num or email cant be empty</center>");
			RequestDispatcher dispatch = request.getRequestDispatcher("registration.html");
			dispatch.include(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
