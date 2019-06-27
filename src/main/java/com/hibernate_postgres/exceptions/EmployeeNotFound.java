package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class EmployeeNotFound extends RuntimeException{
	public EmployeeNotFound(String errorMessage) {
		super(errorMessage);
	}
}
