package com.server;

import java.sql.SQLException;

import com.model.Visitor;

public interface Visitor_inter {
	public void addMessage(Visitor v,String title) throws SQLException;
}
