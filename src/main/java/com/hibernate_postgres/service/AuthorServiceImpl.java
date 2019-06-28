package com.hibernate_postgres.service;

import com.hibernate_postgres.bean.AuthorBean;
import com.hibernate_postgres.bean.BookBean;
import com.hibernate_postgres.dao.AuthorDAO;
import com.hibernate_postgres.dao.AuthorDAOImpl;

public class AuthorServiceImpl implements AuthorService{

	AuthorDAO authordao = new AuthorDAOImpl();

	public void getDetail(AuthorBean author) {
		try {
			authordao.getDetail(author);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertNewBook(BookBean b) {
		try {
			authordao.insertNewBook(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertNewAuthor(AuthorBean a) {
		try {
			authordao.insertNewAuthor(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteBook(BookBean b) {
		try {
			authordao.deleteBook(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAuthor(AuthorBean a) {
		try {
			authordao.deleteAuthor(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
