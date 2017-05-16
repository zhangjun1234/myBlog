package com.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;

import com.database.DBUtil;
import com.model.B_article;
import com.model.Visitor;
import com.util.ApplicationContextUtil;

public class Visitor_server implements Visitor_inter {
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

	public void addMessage(Visitor v,String title) throws SQLException {
		String t=null,sid=null;
		Connection conn = Admin_server.getc();
		ApplicationContext ac = Admin_server.geta();
		
		String sql = "" + "insert into Visitor"
				+ "(visit_title ,visitor_message)"
				+ "values(?,?)";
		java.sql.PreparedStatement p = conn.prepareStatement(sql);
		p.setString(1, title);
		p.setString(2, v.getVisitor_message());
		p.execute();
		p.close();
		
		String sql2 ="" + " select article_review from  b_article "
				+ " where article_title=?  ";
		java.sql.PreparedStatement p2 = conn.prepareStatement(sql2);
		p2.setString(1, title);
		ResultSet rs = p2.executeQuery();
		while (rs.next()) {
			t = rs.getString("article_review");
		}
		p2.close();
		
		String sql3 = "" + " select visitor_id from  Visitor"
				+ " where visit_title=?  "+
				" and "+" visitor_message=? ";
		java.sql.PreparedStatement p3 = conn.prepareStatement(sql3);
		p3.setString(1, title);
		p3.setString(2, v.getVisitor_message());
		ResultSet rs2 = p3.executeQuery();
		int id=0;
		while (rs2.next()) {
			id = rs2.getInt("visitor_id");
		}
		p3.close();
		
		sid=String.valueOf(id);
		t+="сн©м"+"["+sid+"]"+":"+v.getVisitor_message()+"/";
		
		StringBuilder sb = new StringBuilder();
		sb.append(" update  b_article ");
		sb.append(" set article_review=? ");
		sb.append(" where article_title=? ");
//		String sql = " update  b_article "
//		              + " set  `article_review`=?  from  b_article"
//				      + " where article_title=?  ";
		java.sql.PreparedStatement p4 = conn.prepareStatement(sb.toString());
		p4.setString(1, t);
		p4.setString(2, title);
		p4.execute();
		
	}





}
//	public String showreview(String title ) throws SQLException{
//	    Connection conn = Admin_server.getc();
//	    ApplicationContext ac = Admin_server.geta();
//		String sql2 ="" + " select article_review from  b_article "
//				+ " where article_title=?  ";
//		java.sql.PreparedStatement p2 = conn.prepareStatement(sql2);
//		p2.setString(1, title);
//		ResultSet rs = p2.executeQuery();
//		String t = null;
//		while (rs.next()) {
//			t = rs.getString("article_review");
//		}
//		return t;
//	}
//		public  int showid(String title,String mes) throws SQLException{
//			Connection conn = Admin_server.getc();
//			 ApplicationContext ac = Admin_server.geta();
//		String sql3 = "" + " select visitor_id from  Visitor"
//				+ " where visit_title=?  "+
//				" and "+" visitor_message=? ";
//		java.sql.PreparedStatement p3 = conn.prepareStatement(sql3);
//		p3.setString(1, title);
//		p3.setString(2, mes);
//		ResultSet rs = p3.executeQuery();
//		int id=0;
//		while (rs.next()) {
//			id = rs.getInt("visitor_id");
//		}
//		return id;
//	}
//		public  void upd_btitle(String t,String title) throws SQLException{
//		Connection conn = Admin_server.getc();
//		ApplicationContext ac = Admin_server.geta();
//		StringBuilder sb = new StringBuilder();
//		sb.append(" update  b_article ");
//		sb.append(" set article_review=? ");
//		sb.append(" where article_title=? ");
////		String sql = " update  b_article "
////		              + " set  `article_review`=?  from  b_article"
////				      + " where article_title=?  ";
//		java.sql.PreparedStatement p = conn.prepareStatement(sb.toString());
//		p.setString(1, t);
//		p.setString(2, title);
//		p.execute();
//	}
//	
//}
