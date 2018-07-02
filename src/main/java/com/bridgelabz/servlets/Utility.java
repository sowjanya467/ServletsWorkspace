package com.bridgelabz.servlets;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Utility {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection setConnection() 
	{

			try {
				con = DataSource.getInstance().getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

		return con;
	}
	public void closeConnection() throws SQLException 
	{
	if (rs != null) {
		rs.close();
	}
	if (pstmt != null) {
		pstmt.close();
	}
	if (con != null) {
		con.close();
	}
	}
}
