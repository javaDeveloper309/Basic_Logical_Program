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
import com.cms.dao.OrphanageDao;
import com.cms.details.RestaurantDetails;
import com.cms.pojo.Orphanage;
import com.cms.pojo.Restaurant;
import com.cms.queries.QueryConstants;

public class OrphanageDaoImpl implements OrphanageDao {
	Scanner scan = new Scanner(System.in);
	public static PreparedStatement ps = null;;
	public static ResultSet rs = null;
	public static Connection cu = null;

	@Override
	public int addOrphanages(Orphanage or) throws SQLException, IOException {

		int add = 0;
		System.out.println("Enter how many Orphanages you want to add into the database");
		int size = scan.nextInt();
		for (int i = 1; i <= size; i++) {
			cu = ConnectionUtility.getConnection();
			System.out.println("Enter Orphanage Name");
			String name = scan.next();
			System.out.println("Enter Orphanage Address");
			String address = scan.next();
			System.out.println("Enter Orphanage phoneNumber");
			long number = scan.nextLong();
			System.out.println("Enter Orphanage email");
			String email = scan.next();
			System.out.println("Enter whether you  Needfood  or NoNeedfood  ");
			String food = scan.next();
			ps = cu.prepareStatement(QueryConstants.insert_oquery);
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

	@Override
	public List<Orphanage> viewAllOrphanages() throws SQLException, IOException {
		List<Orphanage> viewall = new ArrayList<>();
		cu = ConnectionUtility.getConnection();
		ps = cu.prepareStatement(QueryConstants.viewAll_oquery);
		rs = ps.executeQuery();
		while (rs.next()) {
			Orphanage o = new Orphanage(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),
					rs.getString(6));
			viewall.add(o);
		}
		return viewall;
	}

	@Override
	public Orphanage viewOrphanage(String name) throws SQLException, IOException {
		Orphanage o1 = null;
		cu = ConnectionUtility.getConnection();
		ps = cu.prepareStatement(QueryConstants.viewOne_oquery);
		ps.setString(1, name);
		rs = ps.executeQuery();
		while (rs.next()) {
			o1 = new Orphanage(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5),
					rs.getString(6));
		}
		return o1;
	}

	@Override
	public int updateOrphanage(String name) throws SQLException, IOException {
		int update = 0;
		cu = ConnectionUtility.getConnection();
		System.out.println("Update the food Availability");
		String food = scan.next();
		ps = cu.prepareStatement(QueryConstants.update_oquery);
		ps.setString(1, food);
		ps.setString(2, name);
		update = ps.executeUpdate();
		return update;
	}

	@Override
	public void checkFoodAvailability(String address) throws SQLException, IOException {
		cu = ConnectionUtility.getConnection();
		List<Restaurant> view = RestaurantDetails.rdaoimpl.viewAllRestaurants();
		for (Restaurant r : view) {
			if (r.getrAddress().equalsIgnoreCase(address) && r.getFoodAvalability().equalsIgnoreCase("available")) {
				ps = cu.prepareStatement(QueryConstants.check_availabilityquery);
				ps.setString(1, address);
				ps.setString(2, address);
				rs = ps.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
					}
				} else {
					System.err.println("In given Address Food is NotAvailable in any Restaurant");
				}
			}
		}

	}

}
