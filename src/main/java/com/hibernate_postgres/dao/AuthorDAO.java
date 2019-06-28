package com.hibernate_postgres.dao;

import com.hibernate_postgres.bean.AuthorBean;
import com.hibernate_postgres.bean.BookBean;

public interface AuthorDAO {

	public void getDetail(AuthorBean author) throws Exception;
	public void insertNewBook(BookBean b) throws Exception;
	public void insertNewAuthor(AuthorBean a) throws Exception;
	public void deleteBook(BookBean b) throws Exception;
	public void deleteAuthor(AuthorBean a) throws Exception;
	
}
