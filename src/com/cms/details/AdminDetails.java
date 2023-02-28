package com.cms.details;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.cms.client.Client;

public class AdminDetails {
	public static String userName = "rajitha";
	public static String password = "22185";

	public static void adminInfo() throws SQLException, IOException {

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("*********************************************");
			System.out.println("........WELCOME TO CHERISH MANAGEMENT SYSTEM");
			System.out.println("*********************************************");
			System.out.println("Enter.......1)Restaurant");
			System.out.println("Enter.......2)Orphanage");
			System.out.println("Enter.......3)Check Food Availability");
			System.out.println("Enter.......4)Check Food Need");
			System.out.println("Enter.......5)Back");
			System.out.println("*********************************************");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				RestaurantDetails.RestaurantInfo();
				break;
			case 2:
				OrphanageDetails.OrphanageInfo();
				break;
			case 3:
				System.out.println("Enter address to checkfood Availability in Restaurants");
				String address = scan.next();
				OrphanageDetails.odaoimpl.checkFoodAvailability(address);

				break;
			case 4:
				System.out.println("Enter address to check food need in orphanages");
				String address1 = scan.next();
				RestaurantDetails.rdaoimpl.checkFoodNeed(address1);

				break;
			case 5:
				Client.main(null);
				break;
			default:
				System.out.println("Choose valid option");
			}
		}
	}
}
