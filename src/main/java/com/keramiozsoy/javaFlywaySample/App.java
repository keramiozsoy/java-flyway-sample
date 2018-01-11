package com.keramiozsoy.javaFlywaySample;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author user
 * 
 */
public class App {

	static Connection c = null;

	public static void main(String[] args) {

		try {
			c = JDBCUtil.OpenJdbcConnection(
					//
					"org.apache.derby.jdbc.EmbeddedDriver", //
					"jdbc:derby:src/main/resources/testDerbyDB;create=true",
					"", "");
		} catch (SQLException e1) {
			System.out.println("Driver problem");
			e1.printStackTrace();
		}

		FlywayUtil.initialize();

		JDBCUtil.getAllDatas(c);
		
		JDBCUtil.flwvayInfo(c);
		
		JDBCUtil.closeConnection(c);
	}
}
