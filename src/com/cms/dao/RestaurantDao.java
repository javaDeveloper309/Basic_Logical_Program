package com.cms.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cms.pojo.Orphanage;
import com.cms.pojo.Restaurant;

public interface RestaurantDao {
	
	public int addRestauranrts(Restaurant rs) throws SQLException, IOException;

	public List<Restaurant> viewAllRestaurants() throws SQLException, IOException;

	public Restaurant viewRestaurant(String address) throws SQLException, IOException;

	public int updateRestaurant(String name) throws SQLException, IOException;

	public void checkFoodNeed(String address) throws SQLException, IOException;
}
