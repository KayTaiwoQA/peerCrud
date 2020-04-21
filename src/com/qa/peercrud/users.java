package com.qa.peercrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class users {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/peerdb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";

	Connection conn = null;
	Statement stmt = null;

	public users() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Starting connection to db");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected!!");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createUser(String username, String password, String firstname, String lastname) {
		String update = "INSERT INTO " + "users" + " Values(0,'" + username + "','" + password + "','" + firstname
				+ "','" + lastname + "')";
		try {
			stmt.executeUpdate(update);
			System.out.println("Statement inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readUsers() {
		String read = "SELECT userID,username,password,firstname,lastname from users";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int ID = rs.getInt("userID");
				String uname = rs.getString("username");
				String pw = rs.getString("password");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				System.out.println(ID + " " + uname + " " + pw + " " + fname + " " + lname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateusers(String set, String setto, String where, String whereis) {
		System.out.println("Updating statement");

		String update = "UPDATE users SET " + set + " = '" + setto + "' WHERE " + where + " = '" + whereis + "'";
		try {
			stmt.executeUpdate(update);
			System.out.println("updated");
		} catch (SQLException e) {
			// TODO manually typing this is dumb
			System.out.println("failure to launch");
			e.printStackTrace();
		}
	}

	public void deleteuser(int id) {
		System.out.println("Delete Statement");
		String delete = "DELETE FROM users WHERE userID = " + id;
		try {
			stmt.executeUpdate(delete);
			System.out.println("records deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
