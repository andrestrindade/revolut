package com.revolut.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides an embedded in memory H2 connection with a tiny database.
 * @author Andre
 *
 */
public class H2ConnectionProvider {
	
	private static final String H2_DRIVER = "org.h2.Driver";
	private static final String H2_URL = "jdbc:h2:mem:test;INIT=runscript from '~/create.sql'\\;runscript from '~/init.sql'";
	private static final String H2_USER = "";
	private static final String H2_PASSWORD = "";
	
	public static Connection getConnection() {
		Connection h2Connection = null;
		try {
			Class.forName(H2_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			h2Connection = DriverManager.getConnection(H2_URL, H2_USER, H2_PASSWORD);
			h2Connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return h2Connection;
	}
	
}
