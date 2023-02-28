package com.cms.details;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.cms.daoimpl.RestaurantDaoImpl;
import com.cms.pojo.Restaurant;

public class RestaurantDetails {
	public static RestaurantDaoImpl rdaoimpl = new RestaurantDaoImpl();
	static Restaurant r = new Restaurant();

	public static void RestaurantInfo() throws SQLException, IOException {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("***************************************************");
			System.out.println("Enter......1->Add Restaurants");
			System.out.println("Enter......2->View All Restaurants");
			System.out.println("Enter......3->View Restaurant");
			System.out.println("Enter......4->Update Restaurant");
			System.out.println("Enter......5->Check Food Need");
			System.out.println("Enter......6->Back");
			System.out.println("***************************************************");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				int added = rdaoimpl.addRestauranrts(r);
				if (added != 0) {
					System.out.println("Restaurant added to database....");
				} else {
					System.out.println("Restaurant not added to database....");
				}
				break;
			case 2:
				List<Restaurant> viewall = rdaoimpl.viewAllRestaurants();
				if (viewall != null) {
					for (Restaurant r : viewall) {
						System.out.format("%-10s%-20s%-20s%-25s%-30s%-15s\n ", r.getrId(), r.getrName(),
								r.getrAddress(), r.getrMobileNo(), r.getEmail(), r.getFoodAvalability());
					}
				} else {
					System.err.println("List is empty");
				}
				break;
			case 3:
				System.out.println("Enter Restaurant name ");
				String name = scan.next();
				Restaurant r1 = rdaoimpl.viewRestaurant(name);
				if (r1 != null) {
					System.out.format("%-10s%-20s%-20s%-25s%-30s%-15s\n ", r1.getrId(), r1.getrName(), r1.getrAddress(),
							r1.getrMobileNo(), r1.getEmail(), r1.getFoodAvalability());
				} else {
					System.out.println("No Restaurant is there by " + name + " this name");
				}
				break;
			case 4:
				System.out.println("Enter Restaurant name ");
				String name1 = scan.next();
				int update = rdaoimpl.updateRestaurant(name1);
				if (update != 0) {
					System.out.println("Restaurant Data updated");
				} else {
					System.out.println("Restaurant Data not updated");
				}
				break;
			case 5:
				System.out.println("Enter Orphanage Address");
				String address = scan.next();
				rdaoimpl.checkFoodNeed(address);
				break;
			case 6:
				AdminDetails.adminInfo();
				break;
			default:
				System.out.println("Choose valid option");
			}
		}
	}
}
