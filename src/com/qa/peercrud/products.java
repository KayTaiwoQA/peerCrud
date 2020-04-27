package com.qa.peercrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class products {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/peerdb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";

	Connection conn = null;
	Statement stmt = null;

	public products() {
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

	public void addProducts(String productName, double price, int stock) {
		String update = "INSERT INTO " + "products" + " Values(0,'" + productName + "','" + price + "','" + stock
				+ "')";
		try {
			stmt.executeUpdate(update);
			System.out.println("product inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewProducts() {
		String read = "SELECT productID,productName,price,stock from products";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				int ID = rs.getInt("productID");
				String pname = rs.getString("productName");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				System.out.println(ID + " " + pname + " " + price + " " + stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateProducts(String set, String setto, String where, String whereis) {

		System.out.println("Updating products");

		String update = "UPDATE products SET " + set + " = '" + setto + "' WHERE " + where + " = '" + whereis + "'";
		try {
			stmt.executeUpdate(update);
			System.out.println("updated");
		} catch (SQLException e) {
			// TODO manually typing this is dumb
			System.out.println("failure to launch");
			e.printStackTrace();
		}
	}

	public void deleteProducts(int id) {
		System.out.println("Delete Products");
		String delete = "DELETE FROM products WHERE productID = " + id;
		try {
			stmt.executeUpdate(delete);
			System.out.println("records deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
