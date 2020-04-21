package com.qa.peercrud;

import java.util.Scanner;

public class runner {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("users, products or orders");
		String tablename = sc.nextLine();
		System.out.println("Create, read, update, or delete");
		String process = sc.nextLine();
		
		switch (tablename) {
		case "users":
			users cd = new users();

			switch (process) {
			case "create":
				System.out.println("customer's username: ");
				String username = sc.nextLine();

				System.out.println("customer's password: ");
				String password = sc.nextLine();

				System.out.println("customer's first name: ");
				String firstname = sc.nextLine();

				System.out.println("customer's last name: ");
				String lastname = sc.nextLine();

				cd.createUser(username, password, firstname, lastname);
			case "read":
				cd.readUsers();
			case "update":
				System.out.println("column to set: ");
				String set = sc.nextLine();

				System.out.println("set values to: ");
				String setto = sc.nextLine();

				System.out.println("where: ");
				String where = sc.nextLine();

				System.out.println("is equal to: ");
				String whereis = sc.nextLine();
				cd.updateusers(set, setto, where, whereis);
			case "delete":
				System.out.println("Which user ID to delete?");
				int id = sc.nextInt();
				cd.deleteuser(id);
			}
			
		case "products":
			products pd = new products();
			switch (process) {
			case "create":
				System.out.println("product Name: ");
				String pname = sc.nextLine();

				System.out.println("price: ");
				double pprice = sc.nextDouble();

				System.out.println("stock: ");
				int stock = sc.nextInt();

				pd.addProducts(pname, pprice, stock);
			case "read":
				pd.viewProducts();
			case "update":
				System.out.println("column to set: ");
				String set = sc.nextLine();

				System.out.println("set values to: ");
				String setto = sc.nextLine();

				System.out.println("where: ");
				String where = sc.nextLine();

				System.out.println("is equal to: ");
				String whereis = sc.nextLine();
				pd.updateProducts(set, setto, where, whereis);
			case "delete":
				System.out.println("Which product ID to delete?");
				int id = sc.nextInt();
				pd.deleteProducts(id);
			}
			
		case "orders":
			orders od = new orders();

			switch (process) {
			case "create":
				System.out.println("Product ID: ");
				int productID = sc.nextInt();

				System.out.println("User ID: ");
				int userID = sc.nextInt();
				System.out.println("quantity: ");
				int quantity = sc.nextInt();

				System.out.println("price: ");
				double price = sc.nextDouble();

				od.createOrders(productID, userID, quantity, price);

			case "read":
				od.readOrders();

			case "update":
				System.out.println("column to set: ");
				String set = sc.nextLine();

				System.out.println("set values to: ");
				String setto = sc.nextLine();

				System.out.println("where: ");
				String where = sc.nextLine();

				System.out.println("is equal to: ");
				String whereis = sc.nextLine();
				od.updateOrders(set, setto, where, whereis);

			case "delete":
				System.out.println("Which user ID to delete?");
				int id = sc.nextInt();
				od.deleteOrders(id);
			}
		}
		sc.close();
	}
}