package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ChangePassword extends HttpServlet 
{
	RequestDispatcher dispatcher = null;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Utility u =new Utility();

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		// Get form data
		String user_name = req.getParameter("user_name");
		String currentPassword = req.getParameter("currentPassword");
		String newPasssword = req.getParameter("newPassword");
		String reNewPassword = req.getParameter("renternewPassword");

		// Check New Password & Retype New Password is Same
		if (newPasssword.equals(reNewPassword)) 
		{
			// New Password = Retype New Password; Hence Update
			Connection con = null;
			PreparedStatement pstmt = null;
			try
			{
				// Load the driver
				Class.forName("com.mysql.jdbc.Driver");
				// 2. Get the DB Connection via Driver
				String dbUrl = "jdbc:mysql://localhost:3306/logincredentials?user=root&password=root";
				con = DriverManager.getConnection(dbUrl);
				// Issue SQL queries via connection
				String query = "update login set password=? where user_name=?";

				System.out.println("Query=" + query);
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, newPasssword);

				pstmt.setString(2, user_name);

				pstmt.executeUpdate();

			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
				   u.closeConnection();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}

			dispatcher = req.getRequestDispatcher("changepassword.html");
			dispatcher.include(req, resp);

		}
	}
}