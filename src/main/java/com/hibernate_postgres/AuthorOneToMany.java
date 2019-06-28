package com.hibernate_postgres;

import com.hibernate_postgres.bean.AuthorBean;
import com.hibernate_postgres.bean.BookBean;
import com.hibernate_postgres.service.AuthorService;
import com.hibernate_postgres.service.AuthorServiceImpl;

public class AuthorOneToMany {
	public static void main(String[] args) {

		AuthorBean author = new AuthorBean();
		AuthorService authorService = new AuthorServiceImpl();
		
		author.setAuthorId(101);
		author.setMobile("45682");
		author.setName("New Author");
		authorService.getDetail(author);
		
		BookBean book = new BookBean();
		book.setAuthor(author);
		book.setBookId(11);
		book.setIsbn("ISBN638365");
		book.setName("Madame Bovary");
		
//		authorService.insertNewBook(book);
		
//		authorService.insertNewAuthor(author);	
		
//		authorService.deleteBook(book);
		
//		authorService.deleteAuthor(author);
		
	}
}
