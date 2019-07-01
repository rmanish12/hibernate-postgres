package com.hibernate_postgres.service;

import com.hibernate_postgres.bean.AuthorBean;
import com.hibernate_postgres.bean.BookBean;

public interface AuthorService {

	public void getDetail(AuthorBean author);
	public void insertNewBook(BookBean b);
	public void insertNewAuthor(AuthorBean a);
	public void deleteBook(BookBean b);
	public void deleteAuthor(AuthorBean a);
	
}
