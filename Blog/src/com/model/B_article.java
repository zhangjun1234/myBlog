package com.model;

public class B_article {
	private int blogger_id;
	private String article_title;
	private String article_content;
	private String article_review;
	private String article_type;
	public String getArticle_type() {
		return article_type;
	}

	public void setArticle_type(String article_type) {
		this.article_type = article_type;
	}

	public int getBlogger_id() {
		return blogger_id;
	}

	public void setBlogger_id(int blogger_id) {
		this.blogger_id = blogger_id;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public String getArticle_review() {
		return article_review;
	}

	public void setArticle_review(String article_review) {
		this.article_review = article_review;
	}
}
