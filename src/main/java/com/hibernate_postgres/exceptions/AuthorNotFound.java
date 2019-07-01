package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class AuthorNotFound extends RuntimeException{
	public AuthorNotFound(String errorMessage) {
		super(errorMessage);
	}
}
