package com.hibernate_postgres.exceptions;

@SuppressWarnings(value = { "serial" })
public class UserNotFound extends RuntimeException{

	public UserNotFound(String errorMessage) {
		super(errorMessage);
	}
}
