package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class StudentAlreadyExists extends RuntimeException{
	public StudentAlreadyExists(String errorMessage) {
		super(errorMessage);
	}
}
