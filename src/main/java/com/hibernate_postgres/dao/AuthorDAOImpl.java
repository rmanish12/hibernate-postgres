package com.hibernate_postgres.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_postgres.bean.AuthorBean;
import com.hibernate_postgres.bean.BookBean;
import com.hibernate_postgres.entity.AuthorEntity;
import com.hibernate_postgres.entity.BookEntity;
import com.hibernate_postgres.exceptions.AuthorAlreadyExists;
import com.hibernate_postgres.exceptions.AuthorNotFound;
import com.hibernate_postgres.exceptions.BookAlreadyExists;
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
		AuthorBean authorBean = null;
		BookBean bookBean = null;
		
		try {
			session.beginTransaction();
			
			authorDetails = session.get(AuthorEntity.class, author.getAuthorId());
			
			if(authorDetails!=null) {
				
				bookBean = new BookBean();
				List<BookBean> books = new ArrayList<BookBean>();
				
				for(BookEntity b: authorDetails.getBooks()) {
					bookBean.setBookId(b.getBookId());
					bookBean.setIsbn(b.getIsbn());
					bookBean.setName(b.getName());
					
					books.add(bookBean);
				}
				
				authorBean = new AuthorBean();
				
				authorBean.setAuthorId(authorDetails.getAuthorId());
				authorBean.setMobile(authorDetails.getMobile());
				authorBean.setName(authorDetails.getName());
				authorBean.setBooks(books);
				logger.info("AuthorFetched: " + authorBean);
			} else {
				throw new BookNotFound("Could not fetch details. Record not found.");
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public void insertNewBook(BookBean b) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(BookEntity.class)
											.addAnnotatedClass(AuthorEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		BookEntity book = null;
		AuthorEntity author = null;
		
		try {
			session.beginTransaction();
			
			book = session.get(BookEntity.class, b.getBookId());
			
			if(book==null) {
				author = session.get(AuthorEntity.class, b.getAuthor().getAuthorId());
				
				book = new BookEntity();
				book.setBookId(b.getBookId());
				book.setIsbn(b.getIsbn());
				book.setName(b.getName());
				book.setAuthor(author);
				
				session.save(book);
				session.getTransaction().commit();
				
				logger.info("Book inserted successfully");
			} else {
				throw new BookAlreadyExists("Could not insert. This book is already present");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public void insertNewAuthor(AuthorBean a) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(AuthorEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		AuthorEntity author = null;
		List<BookEntity> books = null;
		BookEntity book = null;
		
		try {
			session.beginTransaction();
			
			author = session.get(AuthorEntity.class, a.getAuthorId());
			
			if(author==null) {
				author = new AuthorEntity();
				book = new BookEntity();
				books = new ArrayList<BookEntity>();
				books.add(book);
				
				author.setAuthorId(a.getAuthorId());
				author.setMobile(a.getMobile());
				author.setName(a.getName());
				author.setBooks(books);
				
				session.save(author);
				session.getTransaction().commit();	
				
				logger.info("Author inserted successfully.");
			} else {
				throw new AuthorAlreadyExists("Could not insert record. Author already exists");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public void deleteBook(BookBean b) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(BookEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		BookEntity book = null;
		
		try {
			session.beginTransaction();
			
			book = session.get(BookEntity.class, b.getBookId());
			
			if(book!=null) {
				session.delete(book);
				session.getTransaction().commit();
				
				logger.info("Book deleted successfully");
			} else {
				throw new BookNotFound("Could not delete. Book not found");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public void deleteAuthor(AuthorBean a) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(AuthorEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		AuthorEntity author = null;
		
		try {
			session.beginTransaction();
			
			author = session.get(AuthorEntity.class, a.getAuthorId());
			
			if(author!=null) {
				session.delete(author);
				session.getTransaction().commit();
				
				logger.info("Author deleted successfully");
			} else {
				throw new AuthorNotFound("Could not delete. This author is not present");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
}
