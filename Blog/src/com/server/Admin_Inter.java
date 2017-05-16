package com.server;

import java.sql.SQLException;
import java.util.List;

import com.model.Blogger;

public interface Admin_Inter {
	public void addBlogger(Blogger b) throws SQLException;
	public void delBlogger(Integer id) throws SQLException;
	public void updateBlogger(Blogger b) throws SQLException;
	public List<Blogger> queryAllblogger() throws SQLException;
	public Blogger queryBlogger(Integer id) throws SQLException;
}
