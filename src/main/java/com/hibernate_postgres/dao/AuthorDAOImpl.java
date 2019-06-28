package com.hibernate_postgres.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_postgres.bean.AuthorBean;
import com.hibernate_postgres.entity.AuthorEntity;
import com.hibernate_postgres.entity.BookEntity;
import com.hibernate_postgres.exceptions.BookNotFound;

public class AuthorDAOImpl implements AuthorDAO{
	
	static Logger logger = Logger.getLogger(BookEntity.class);

	public void getDetail(AuthorBean author) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(BookEntity.class)
											.addAnnotatedClass(AuthorEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		AuthorEntity authorDetails = null;
		
		try {
			session.beginTransaction();
			
			authorDetails = session.get(AuthorEntity.class, author.getAuthorId());
			
			if(authorDetails!=null) {
				logger.info("AuthorFetched: ");
			} else {
				throw new BookNotFound("Could not fetch details. Record not found.");
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
}
