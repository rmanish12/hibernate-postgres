package com.hibernate_postgres.service;

import com.hibernate_postgres.bean.AuthorBean;
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

	

}
