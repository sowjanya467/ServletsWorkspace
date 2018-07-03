package com.bridgelabz.servlets;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{

	private static final long serialVersionUID = -2451053518061528180L;
	Utility utility = new Utility();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	{

		String user_name = req.getParameter("user_name");
		String password = req.getParameter("password");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/logincredentials?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			String sql = "select * from login where user_name=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			if (rs.next()) 
			{
				HttpSession session = req.getSession(true);
				
				session.setMaxInactiveInterval(1 * 60);
				session.setAttribute("user_name", user_name);
				  
				RequestDispatcher dispatch = req.getRequestDispatcher("PreSuccess");
				dispatch.forward(req, resp);
				if(session.isNew())
				{
					    ServletContext ctx=getServletContext();  
				        int t=(Integer)ctx.getAttribute("total_users");  
				        int c=(Integer)ctx.getAttribute("current_users");  
				        out.print("<br>total users= "+t);  
				        out.print("<br>current users= "+c);

				}
			} 
			else 
			{
				HttpSession session = req.getSession(true);
				session.setAttribute("user_name", user_name);
				RequestDispatcher dispatch = req.getRequestDispatcher("PreError");
				dispatch.forward(req, resp);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				utility.closeConnection();

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();

			}
		}

	}
}