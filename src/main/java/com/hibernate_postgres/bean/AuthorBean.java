package com.hibernate_postgres.bean;

import java.util.List;

public class AuthorBean {

	private int authorId;
	private String name;
	private String mobile;
	private List<BookBean> books;
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public List<BookBean> getBooks() {
		return books;
	}
	public void setBooks(List<BookBean> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "AuthorBean [authorId=" + authorId + ", name=" + name + ", mobile=" + mobile + ", books=" + books + "]";
	}
		
}
