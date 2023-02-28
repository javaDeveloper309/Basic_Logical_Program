package com.cms.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.cms.details.AdminDetails;

public class Client {
	public static void main(String[] args) throws SQLException, IOException {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("***************************************************");
			System.out.println(" Enter.......1->Login ");
			System.out.println(" Enter.......2->Logout");
			System.out.println("***************************************************");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter UserName ");
				String uname = scan.next();
				System.out.println("Enter password");
				String password = scan.next();
				if (AdminDetails.userName.equalsIgnoreCase(uname) && AdminDetails.password.equalsIgnoreCase(password)) {
					AdminDetails.adminInfo();
				} else {
					System.err.println("Invalid UserName and Password");
				}
				break;
			case 2:
				System.out.println(".........Thank you for Using the Application......");
				System.exit(0);
			}
		}
	}
}
