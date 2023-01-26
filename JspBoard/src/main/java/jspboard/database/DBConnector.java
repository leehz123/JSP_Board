package jspboard.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static String id = "hr";
	private static String pw = "1234";
	
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC Loading Succeess...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC Loading Failed...");
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}