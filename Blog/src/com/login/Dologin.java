package com.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.database.DBUtil;
import com.server.Admin_server;
import com.util.ApplicationContextUtil;

public class Dologin implements Dologin_inter {
	public static Connection getc() {
		Connection conn = null;
		ApplicationContext ac = null;
		ac = Admin_server.geta();
		DBUtil db = (DBUtil) ac.getBean("dbutil");
		conn = db.getconnection();
		return conn;
	}

	public static ApplicationContext geta() {

		ApplicationContext ac = null;
		ac = ApplicationContextUtil.getApplicationContext();
		return ac;
	}

	public int checkblogger(String name, String pwd) throws SQLException {

		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		String sql = " " + " select blogger_id from  blogger "
				+ " where blogger_name=? and blogger_password=? ";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, name);
		p.setString(2, pwd);
		ResultSet rs = p.executeQuery();
		int b_id = 0;
		while (rs.next()) {
			b_id = rs.getInt("blogger_id");
		}
		return b_id;
	}
	public int checkadmin(String name, String pwd) throws SQLException{
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		String sql = " " + " select adminer_id from  adminer "
				+ " where adminer_name=? and adminer_password=? ";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, name);
		p.setString(2, pwd);
		ResultSet rs = p.executeQuery();
		int a_id = 0;
		while (rs.next()) {
			a_id = rs.getInt("blogger_id");
		}
		return a_id;
	}
	
}
