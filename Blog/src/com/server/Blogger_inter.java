package com.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.model.B_article;

public interface Blogger_inter {
	public int getBlogger_id();
	public void setBlogger_id(int blogger_id);
	public void addArticle(B_article b) throws SQLException;
	public void delArticle(String title) throws SQLException;
	public void editArticle(B_article b, Map<String, String> map)throws SQLException;
	public List<String> showAlltitle() throws SQLException;
	public Map<String, String> showAll(String title) throws SQLException;
	public String [] getreview(String title) throws SQLException;
	public void  blogger_reply(int id,String title,String reply) throws SQLException;
}
