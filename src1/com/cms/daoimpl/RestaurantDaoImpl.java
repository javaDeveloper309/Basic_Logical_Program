package com.cms.daoimpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cms.connection.ConnectionUtility;
import com.cms.dao.RestaurantDao;
import com.cms.pojo.Orphanage;
import com.cms.pojo.Restaurant;
import com.cms.queries.QueryConstants;

public class RestaurantDaoImpl implements RestaurantDao {
	Scanner scan = new Scanner(System.in);
	public static PreparedStatement ps = null;;
	public static ResultSet rs = null;
	public static Connection cu = null;
	OrphanageDaoImpl or = new OrphanageDaoImpl();

	@Override
	// method to add Restaurants into database
	public int addRestauranrts(Restaurant rs) throws SQLException, IOException {
		int add = 0;
		System.out.println("Enter how many Restaurants you want to add in database");
		int size = scan.nextInt();
		for (int i = 1; i <= size; i++) {
			cu = ConnectionUtility.getConnection();
			System.out.println("Enter Restaurant Name");
			String name = scan.next();
			System.out.println("Enter Restaurant Address");
			String address = scan.next();
			System.out.println("Enter Restaurant phoneNumber");
			long number = scan.nextLong();
			System.out.println("Enter Restaurant email");
			String email = scan.next();
			System.out.println("Enter whether the food Available or NotAvailable in Restaurant");
			String food = scan.next();
			ps = cu.prepareStatement(QueryConstants.insert_query);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setLong(3, number);
			ps.setString(4, email);
			ps.setString(5, food);
			add = ps.executeUpdate();
		}
		ConnectionUtility.closePrepareStatement(cu, ps);
		return add;
	}

	// method to display all Restaurants
	@Override
	public List<Restaurant> viewAllRestaurants() throws SQLException, IOException {
		List<Restaurant> viewall = new ArrayList<>();
		cu = ConnectionUtility.getConnection();
		ps = cu.prepareStatement(QueryConstants.viewAll_query);
		rs = ps.executeQuery();
		while (rs.next()) {
			Restaurant r = new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4),
					rs.getString(5), rs.getString(6));
			viewall.add(r);
		}
		return viewall;
	}

	// method to display one Restaurant
	@Override
	public Restaurant viewRestaurant(String name) throws SQLException, IOException {
		Restaurant r1 = null;
		cu = ConnectionUtility.getConnection();
		ps = cu.prepareStatement(QueryConstants.viewOne_query);
		ps.setString(1, name);
		rs = ps.executeQuery();
		while (rs.next()) {
			r1 = new Restaurant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),
					rs.getString(6));
		}
		return r1;
	}

	// method to update Restaurant data
	@Override
	public int updateRestaurant(String name) throws SQLException, IOException {
		int update = 0;
		cu = ConnectionUtility.getConnection();
		System.out.println("Update the food Availability");
		String food = scan.next();
		ps = cu.prepareStatement(QueryConstants.update_query);
		ps.setString(1, food);
		ps.setString(2, name);
		update = ps.executeUpdate();
		return update;
	}

	// method to delete Restaurant data
	@Override
	public void checkFoodNeed(String address) throws SQLException, IOException {
		cu = ConnectionUtility.getConnection();
		List<Orphanage> view = or.viewAllOrphanages();
		for (Orphanage o : view) {
			if (o.getoAddress().equalsIgnoreCase(address) && o.getFoodNeed().equalsIgnoreCase("Need")) {
				ps = cu.prepareStatement(QueryConstants.check_needquery);
				ps.setString(1, address);
				ps.setString(2, address);
				rs = ps.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));

					}
				} else {
					System.out.println("In given address no Orphanage want food");
				}

			}
		}

	}

}
