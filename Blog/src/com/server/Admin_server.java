package com.server;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.database.DBUtil;
import com.model.Blogger;
import com.util.ApplicationContextUtil;

public class Admin_server implements Admin_Inter {
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

	public void addBlogger(Blogger b) throws SQLException {

		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		String sql = ""
				+ "insert into Blogger"
				+ "(blogger_name ,blogger_password,blogger_sex,blogger_age,blogger_birth)"
				+ "values(?,?,?,?,?)";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, b.getBlogger_name());
		p.setString(2, b.getBlogger_password());
		p.setString(3, b.getBlogger_sex());
		p.setInt(4, b.getBlogger_age());
		p.setDate(5, new Date(b.getBlogger_birth().getTime()));
		p.execute();
	}

	public void delBlogger(Integer id) throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		String sql = "" + " delete from  Blogger" + " where blogger_id=?";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, id);
		p.execute();

	}

	public void updateBlogger(Blogger b) throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		String sql = ""
				+ " update Blogger"
				+ " set blogger_name=? ,blogger_password=?,blogger_sex=?,blogger_age=?,blogger_birth=?"
				+ " where blogger_id=?";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, b.getBlogger_name());
		p.setString(2, b.getBlogger_password());
		p.setString(3, b.getBlogger_sex());
		p.setInt(4, b.getBlogger_age());
		p.setDate(5, new Date(b.getBlogger_birth().getTime()));
		p.setInt(6, b.getBlogger_id());
		p.execute();

	}

	public List<Blogger> queryAllblogger() throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		List<Blogger> gb = new ArrayList<Blogger>();
		String sql = "" + " select * from  Blogger";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		ResultSet rs = p.executeQuery();
		Blogger b = null;
		while (rs.next()) {
			b = (Blogger) ac.getBean("blogger");
			b.setBlogger_id(rs.getInt("blogger_id"));
			b.setBlogger_name(rs.getString("blogger_name"));
			b.setBlogger_password(rs.getString("blogger_password"));
			b.setBlogger_sex(rs.getString("blogger_sex"));
			b.setBlogger_age(rs.getInt("blogger_age"));
			b.setBlogger_birth(rs.getDate("blogger_birth"));
			gb.add(b);
		}
		return gb;
	}

	public Blogger queryBlogger(Integer id) throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		StringBuilder sb = new StringBuilder();
		String sql = "" + " select * from  Blogger" + " where blogger_id=? ";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs = p.executeQuery();
		Blogger b = (Blogger) ac.getBean("blogger");
		while (rs.next()) {
			b.setBlogger_id(rs.getInt("blogger_id"));
			b.setBlogger_name(rs.getString("blogger_name"));
			b.setBlogger_password(rs.getString("blogger_password"));
			b.setBlogger_sex(rs.getString("blogger_sex"));
			b.setBlogger_age(rs.getInt("blogger_age"));
			b.setBlogger_birth(rs.getDate("blogger_birth"));

		}
		return b;
	}

}
