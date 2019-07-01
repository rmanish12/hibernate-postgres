package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class AuthorAlreadyExists extends RuntimeException{
	public AuthorAlreadyExists(String errorMessage) {
		super(errorMessage);
	}
}
