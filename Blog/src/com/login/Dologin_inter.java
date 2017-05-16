package com.login;

import java.sql.SQLException;

public interface Dologin_inter {
	public int checkblogger(String name, String pwd) throws SQLException ;
	public int checkadmin(String name, String pwd) throws SQLException;
}
