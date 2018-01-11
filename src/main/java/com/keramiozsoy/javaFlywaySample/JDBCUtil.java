package com.keramiozsoy.javaFlywaySample;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author user
 * 
 */
public class JDBCUtil {

	public static Connection OpenJdbcConnection(final Object driver,
			final String dbPath, final String user, final String password)
			throws SQLException {

		try {
			DriverManager.registerDriver((Driver) Class.forName(
					driver.toString()).newInstance());
			// DriverManager.deregisterDriver(driver);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			System.out.println("Driver can not be found");
			e.printStackTrace();
			throw new SQLException(e);
		}

		Connection conn = DriverManager.getConnection(dbPath, user, password);

		return conn;
	}

	public static void getAllDatas(Connection c) {
		try {
			Statement show = c.createStatement();
			ResultSet rs = show.executeQuery(" SELECT * FROM usertable ");
			while (rs.next()) {
				System.out.println(" -------------- " //
						+ rs.getInt("id") //
						+ " ------ " //
						+ rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void flwvayInfo(Connection c) {
		try {
			Statement show = c.createStatement();
			ResultSet rs = show
					.executeQuery(" SELECT * FROM FLYWAY_SCHEMA_TABLE ");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			
			System.out.println(" SELECT * FROM FLYWAY_SCHEMA_TABLE ");
			while (rs.next()) {
				System.out.println(" - ");
				System.out.print("-" + "-"
				
				+"installed_rank >>"		+ rs.getString(rsmd.getColumnName(1)) + "***"
				+"version >>"		+ rs.getString(rsmd.getColumnName(2)) + "***"
				+"description >>"		+ rs.getString(rsmd.getColumnName(3)) + "***"
				+"type >>"		+ rs.getString(rsmd.getColumnName(4)) + "***"
				+"script >>"		+ rs.getString(rsmd.getColumnName(5)) + "***"
				+"checksum >>"		+ rs.getString(rsmd.getColumnName(6)) + "***"
				+"installed_by >>"		+ rs.getString(rsmd.getColumnName(7)) + "***"
				+"installed_on >>"		+ rs.getString(rsmd.getColumnName(8)) + "***"
				+"execution_time >>"		+ rs.getString(rsmd.getColumnName(9)) + "***"
				+"success >>"		+ rs.getInt(rsmd.getColumnName(10)) + "***");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
