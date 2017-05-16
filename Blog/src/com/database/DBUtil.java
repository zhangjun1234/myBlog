package com.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	// TODO Auto-generated method stub
	private static final String url = "jdbc:mysql://127.0.0.1:3306/Blog";
	private static final String user = "root";
	private static final String password = "1234";
	private static final String  driver="com.mysql.jdbc.Driver";  
	private static  Connection conn ;
	static {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getconnection(){
		return conn;
	}
	

}
