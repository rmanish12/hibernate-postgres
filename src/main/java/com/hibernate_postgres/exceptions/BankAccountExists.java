package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class BankAccountExists extends RuntimeException{
	public BankAccountExists(String errorMessage) {
		super(errorMessage);
	}
}
