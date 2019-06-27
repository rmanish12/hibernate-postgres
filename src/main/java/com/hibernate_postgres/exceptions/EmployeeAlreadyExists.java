package com.hibernate_postgres.exceptions;

@SuppressWarnings(value = { "serial" })
public class EmployeeAlreadyExists extends RuntimeException{
	public EmployeeAlreadyExists(String errorMessage) {
		super(errorMessage);
	}
}
