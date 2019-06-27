package com.hibernate_postgres.exceptions;

@SuppressWarnings(value = { "serial" })
public class UserAlreadyExists extends RuntimeException{
	public UserAlreadyExists(String errorMessage) {
		super(errorMessage);
	}
}
