package com.model;

import java.util.Date;

public class Blogger {
	private int blogger_id;
    private String blogger_name;
	private String blogger_password;
	private String blogger_sex;
	private int blogger_age;
	public int getBlogger_id() {
		return blogger_id;
	}
	public void setBlogger_id(int blogger_id) {
		this.blogger_id = blogger_id;
	}
	public String getBlogger_name() {
		return blogger_name;
	}
	public void setBlogger_name(String blogger_name) {
		this.blogger_name = blogger_name;
	}
	public String getBlogger_password() {
		return blogger_password;
	}
	public void setBlogger_password(String blogger_password) {
		this.blogger_password = blogger_password;
	}
	public String getBlogger_sex() {
		return blogger_sex;
	}
	public void setBlogger_sex(String blogger_sex) {
		this.blogger_sex = blogger_sex;
	}
	
	@Override
	public String toString() {
		return "Blogger [blogger_id=" + blogger_id + ", blogger_name="
				+ blogger_name + ", blogger_password=" + blogger_password
				+ ", blogger_sex=" + blogger_sex + ", blogger_age="
				+ blogger_age + ", blogger_birth=" + blogger_birth + "]";
	}
	public int getBlogger_age() {
		return blogger_age;
	}
	public void setBlogger_age(int blogger_age) {
		this.blogger_age = blogger_age;
	}
	public Date getBlogger_birth() {
		return blogger_birth;
	}
	public void setBlogger_birth(Date blogger_birth) {
		this.blogger_birth = blogger_birth;
	}
	private Date blogger_birth;
}
