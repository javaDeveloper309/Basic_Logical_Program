package com.cms.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cms.pojo.Orphanage;
import com.cms.pojo.Restaurant;

public interface OrphanageDao {

	public int addOrphanages(Orphanage or) throws SQLException, IOException;

	public List<Orphanage> viewAllOrphanages() throws SQLException, IOException;

	public Orphanage viewOrphanage(String name) throws SQLException, IOException;

	public int updateOrphanage(String name) throws SQLException, IOException;

	public void checkFoodAvailability(String address) throws SQLException, IOException;
}
