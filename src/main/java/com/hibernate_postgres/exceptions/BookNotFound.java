package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class BookNotFound extends RuntimeException{
	public BookNotFound(String errorMessage) {
		super(errorMessage);
	}
}
