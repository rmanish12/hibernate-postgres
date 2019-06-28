package com.hibernate_postgres.dao;

import com.hibernate_postgres.bean.AuthorBean;

public interface AuthorDAO {

	public void getDetail(AuthorBean author) throws Exception;
	
}
