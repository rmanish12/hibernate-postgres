package com.hibernate_postgres.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class AuthorEntity {

	@Id
	@Column(name = "author_id")
	private int authorId;
	
	private String name;
	private String mobile;

	@OneToMany(mappedBy = "author", cascade = {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<BookEntity> books;
	
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
	public List<BookEntity> getBooks() {
		return books;
	}
	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}
	
	
}
