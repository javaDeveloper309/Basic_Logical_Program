package com.cms.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtility {
	public static Connection connect = null;

	// method to establish the connection
	public static Connection getConnection() throws SQLException, IOException {
		Properties pro = new Properties();
		FileReader fr = new FileReader("src/com/cms/connection/app.properties");
		pro.load(fr);

		connect = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("userName"),
				pro.getProperty("password"));
		return connect;
	}

	public static void closePrepareStatement(Connection cu, PreparedStatement ps) throws SQLException {
		if (cu != null) {
			cu.close();
		}
		if (ps != null) {
			ps.close();
		}
	}

	public static void closePrepareStatement(Connection cu, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (cu != null) {
			cu.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
}
