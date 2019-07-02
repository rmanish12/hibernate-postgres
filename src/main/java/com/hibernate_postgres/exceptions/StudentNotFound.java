package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class StudentNotFound extends RuntimeException{
	public StudentNotFound(String errorMessage) {
		super(errorMessage);
	}
}
