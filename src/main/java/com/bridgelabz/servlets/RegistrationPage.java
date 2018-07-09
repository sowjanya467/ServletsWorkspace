package com.bridgelabz.servlets;
/*************************************************************************************************************
*
* purpose:Registration Servlet
* @author sowjanya467
* @version 1.0
* @since 4-05-18
*
* **************************************************************************************************/

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationPage extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Utility u = new Utility();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email_id");
		String name = req.getParameter("user_name");
		String password = req.getParameter("password");
		String mobileNum = req.getParameter("mobile_num");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// con = u.setConnection();

			String dbUrl = "jdbc:mysql://localhost:3306/logincredentials?useSSL=false";

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(dbUrl, "root", "root");

			String query = "insert into login (email_id,user_name,password,mobile_num) values(?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setString(4, mobileNum);
			int count = pstmt.executeUpdate();
			if (count > 0) 
			{
				out.println("<html><body><h2>You are successfully registered</h2></body></html>");
				HttpSession session = req.getSession(true);
				session.setAttribute("user_name", name);
				RequestDispatcher dispatch = req.getRequestDispatcher("PreLogin");
				dispatch.forward(req, resp);
			} 
			else {
				out.println("<html><body><h2>You are not registered</h2></body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				u.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}