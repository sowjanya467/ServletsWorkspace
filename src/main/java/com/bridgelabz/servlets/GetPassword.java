package com.bridgelabz.servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetPassword {

	static Connection con = null;
	static PreparedStatement preparedStatement = null;

	public static boolean validation(String username, String password) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/logincredentials?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);
			String query = "select * from user where user_name=? and password=?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			result = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String validationPassword(String email) {
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/logincredentials?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);	
			String query = "select password from user where email_id='" + email + "'";
			preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				password = rs.getString("password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
}

