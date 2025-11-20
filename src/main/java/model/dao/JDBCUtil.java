package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	private static final String url = "jdbc:mysql://127.0.0.1:3306/cnw";
	private static final String username = "root";
	private static final String password = "";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, username, password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
