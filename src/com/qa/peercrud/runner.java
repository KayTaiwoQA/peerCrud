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
				break;
			case "read":
				cd.readUsers();
				break;
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
				break;
			case "delete":
				System.out.println("Which user ID to delete?");
				int id = sc.nextInt();
				cd.deleteuser(id);
				break;
			}
		}
		sc.close();

	}
}
