package com.server;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.database.DBUtil;
import com.model.B_article;
import com.model.Blogger;
import com.util.ApplicationContextUtil;

public class Blogger_server implements Blogger_inter {
	private int blogger_id;

	public int getBlogger_id() {
		return blogger_id;
	}

	public void setBlogger_id(int blogger_id) {
		this.blogger_id = blogger_id;
	}

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

	public void addArticle(B_article b) throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		String sql = "" + "insert into b_article"
				+ "(blogger_id ,article_title,article_content,article_type)"
				+ "values(?,?,?,?)";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, blogger_id);
		p.setString(2, b.getArticle_title());
		p.setString(3, b.getArticle_content());
		p.setString(4, b.getArticle_type());
		p.execute();
	}

	public void delArticle(String title) throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		String sql = "" + " delete from  b_article"
				+ " where blogger_id=? and article_title=? ";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, blogger_id);
		p.setString(2, title);
		p.execute();
	}

	public void editArticle(B_article b, Map<String, String> map)throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		StringBuilder sb = new StringBuilder();
		sb.append(" update  b_article ");
		sb.append(" set article_title=?,article_content=?,article_type=?  ");
		sb.append(" where article_title=? and article_content=? ");
		java.sql.PreparedStatement p = conn.prepareStatement(sb.toString());
		p.setString(1, b.getArticle_title());
		p.setString(2, b.getArticle_content());
		p.setString(3, b.getArticle_type());
		p.setString(4, map.get("title"));
		p.setString(5, map.get("content"));
		p.execute();
	}

	public List<String> showAlltitle() throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		List<String> ts = new ArrayList<String>();
		String sql = "" + " select article_title from  b_article"
				+ " where blogger_id=?  ";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, blogger_id);
		ResultSet rs = p.executeQuery();
		String t = null;
		while (rs.next()) {
			t = rs.getString("article_title");
			ts.add(t);
		}
		return ts;
	}

	public Map<String, String> showAll(String title) throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		Map<String, String> ms = new HashMap<String, String>();
		String sql = ""
				+ " select article_title ,article_content  from  b_article"
				+ " where blogger_id=? and article_title=?  ";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, blogger_id);
		p.setString(2, title);
		ResultSet rs = p.executeQuery();
		Map<String, String> m = null;
		while (rs.next()) {
			ms.put("title", rs.getString("article_title"));
			ms.put("content", rs.getString("article_content"));

		}
		return ms;
	}
	
	public String [] getreview(String title) throws SQLException{
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		String sql = ""
				+ " select article_review from  b_article"
				+ " where blogger_id=? and article_title=?  ";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setInt(1, blogger_id);
		p.setString(2, title);
		ResultSet rs = p.executeQuery();
		String s=null;
		while (rs.next()) {
			s=rs.getString("article_review");
         }
		String [] review=s.split("/");
		return review;
	}
	
	public void  blogger_reply(int id,String title,String reply) throws SQLException {
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		StringBuilder sb = new StringBuilder();
		sb.append(" update  Visitor ");
		sb.append(" set blogger_reply=? ");
		sb.append(" where visit_title=? and visitor_id=?");
		java.sql.PreparedStatement p = conn.prepareStatement(sb.toString());
		p.setString(1, reply);
		p.setString(2, title);
		p.setInt(3, id);
		p.execute();
		
	}
	
}
