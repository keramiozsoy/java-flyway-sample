package com.keramiozsoy.javaFlywaySample;

import org.flywaydb.core.Flyway;

/**
 * 
 * @author user
 * 
 */
public class FlywayUtil {

	public static void initialize() {
		Flyway flyway = new Flyway();
		flyway.setDataSource( //
				"jdbc:derby:src/main/resources/testDerbyDB;create=true", //
				"", //
				""); //
		flyway.setLocations("classpath:migration");
		flyway.setTable("FLYWAY_SCHEMA_TABLE");
		flyway.migrate();
	}

}
