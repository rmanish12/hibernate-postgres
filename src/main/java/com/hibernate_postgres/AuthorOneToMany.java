package com.hibernate_postgres;

import com.hibernate_postgres.bean.AuthorBean;
import com.hibernate_postgres.service.AuthorService;
import com.hibernate_postgres.service.AuthorServiceImpl;

public class AuthorOneToMany {
	public static void main(String[] args) {

		AuthorBean author = new AuthorBean();
		AuthorService authorService = new AuthorServiceImpl();
		
		author.setAuthorId(101);
		authorService.getDetail(author);
		
	}
}
