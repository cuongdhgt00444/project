package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=DailyMealManager";
			String user = "sa";
			String pass = "123456";
			conn = DriverManager.getConnection(url, user, pass);

			System.out.println("connected...");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
		}
		return conn;

	}

}
