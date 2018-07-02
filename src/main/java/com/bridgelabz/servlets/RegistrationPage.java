package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bridgelabz
 *
 */
public class RegistrationPage extends HttpServlet 
{
	/**
	 * 
	 */

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email_id");
		String name = req.getParameter("user_name");
		String password = req.getParameter("password");
		String mobileNum = req.getParameter("mobile_num");
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
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
				out.println("<html><body><h2>You are sucessfully registered</h2></body></html>");
			}
			else
			{
				out.println("<html><body><h2>You are not registered</h2></body></html>");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{

			try {
				if (con != null) 
				{
					con.close();
				}
				if (pstmt != null) 
				{
					pstmt.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}