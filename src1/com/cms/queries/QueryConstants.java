package com.cms.queries;

public class QueryConstants {

	// Restaurant Queries
	public static String insert_query = "insert into restaurant(rName,rAddress,rMobileNo,rEmail,foodAvailability) values(?,?,?,?,?)";

	public static String viewAll_query = "select * from restaurant";

	public static String viewOne_query = "select * from restaurant where rName = ?";

	public static String update_query = "update restaurant set foodAvailability = ? where rName = ?";

	public static String check_needquery = "select rName,oName,foodNeed from restaurant r,Orphanage o where o.oAddress = ? and r.rAddress = ?";

	// Orphanage Queries
	public static String insert_oquery = "insert into orphanage(oName,oAddress,oMobileNo,oEmail,foodNeed) values(?,?,?,?,?)";

	public static String viewAll_oquery = "select * from orphanage";

	public static String viewOne_oquery = "select * from orphanage where oName = ?";

	public static String update_oquery = "update orphanage set foodNeed = ? where oName = ?";

	public static String check_availabilityquery = "select rName,oName,foodAvailability from restaurant r,Orphanage o where r.rAddress = ? and o.oAddress = ?";

}
