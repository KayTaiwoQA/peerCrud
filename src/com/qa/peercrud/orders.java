package com.qa.peercrud;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 

public class orders {

 

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/peerdb?useSSL=false";
    static final String USER = "root";
    static final String PASS = "root";

 

    Connection conn = null;
    Statement stmt = null;

 

    public orders() {
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
    
    
    /*
     *Crud Statement for Orders 
     * CreateOrders =  Insert Into = update
     * ReadOrders   =   Select     =  read
     * UpdateOrders =   update x   = update
     * DeleteOrders =   delete     = delete
     */
    
    //Create Orders
    public void createOrders(int productID, int userID, int quantity, double price) {
        String update = "INSERT INTO " + "orders" + " Values(0,'" + productID + "','" + userID + "','" + quantity
                + "','" + price + "')";
        try {
            stmt.executeUpdate(update);
            System.out.println("Statement inserted into orders.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //Read Orders
    public void readOrders() {
        String read = "SELECT orderID,productID,userID,quantity,price from orders";
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(read);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                int oID = rs.getInt("orderID");
                int pID = rs.getInt("productID");
                int uID = rs.getInt("userID");
                int qtity = rs.getInt("quantity");
                Double pri = rs.getDouble("price");
                System.out.println(oID + " " + pID + " " + uID + " " + qtity + " " + pri);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //UpdateOrders
    
    public void updateOrders(String set, String setto, String where, String whereis) {
        System.out.println("Updating statement");

 

        String update = "UPDATE orders SET " + set + " = '" + setto + "' WHERE " + where + " = '" + whereis + "'";
        try {
            stmt.executeUpdate(update);
            System.out.println("updated");
        } catch (SQLException e) {
            // TODO manually typing this is dumb
            System.out.println("failure to launch");
            e.printStackTrace();
        }
    }
    
    //DeleteOrders
    
    public void deleteOrders(int id) {
        System.out.println("Delete Statement");
        String delete = "DELETE FROM orders WHERE orderID = " + id;
        try {
            stmt.executeUpdate(delete);
            System.out.println("records deleted from orders");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

 

    }

 

}