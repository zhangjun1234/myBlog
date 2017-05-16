package com.model;

public class Visitor {
	private int visitor_id;
	private String visit_title;
	private String visitor_message;

	public int getVisitor_id() {
		return visitor_id;
	}

	public void setVisitor_id(int visitor_id) {
		this.visitor_id = visitor_id;
	}

	public String getVisit_title() {
		return visit_title;
	}

	public void setVisit_title(String visit_title) {
		this.visit_title = visit_title;
	}

	public String getVisitor_message() {
		return visitor_message;
	}

	public void setVisitor_message(String visitor_message) {
		this.visitor_message = visitor_message;
	}
}