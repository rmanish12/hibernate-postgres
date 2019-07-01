package com.hibernate_postgres.bean;

public class BookBean {	
	
	private int bookId;
	private AuthorBean author;
	private String name;
	private String isbn;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public AuthorBean getAuthor() {
		return author;
	}
	public void setAuthor(AuthorBean author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "BookBean [bookId=" + bookId + ", author=" + author + ", name=" + name + ", isbn=" + isbn + "]";
	}
	
	
	
}
