package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class BankDetailsNotFound extends RuntimeException{
	public BankDetailsNotFound(String errorMessage) {
		super(errorMessage);
	}
}
