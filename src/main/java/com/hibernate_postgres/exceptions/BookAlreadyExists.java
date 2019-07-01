package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class BookAlreadyExists extends RuntimeException{
	public BookAlreadyExists(String errorMessage) {
		super(errorMessage);
	}
}
