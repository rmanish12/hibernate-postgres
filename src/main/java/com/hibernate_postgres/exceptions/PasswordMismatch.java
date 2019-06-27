package com.hibernate_postgres.exceptions;

@SuppressWarnings(value = { "serial" })
public class PasswordMismatch extends RuntimeException{
	public PasswordMismatch(String errorMessage) {
		super(errorMessage);
	}
}
