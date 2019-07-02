package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class CourseAlreadyExists extends RuntimeException{
	public CourseAlreadyExists(String errorMessage) {
		super(errorMessage);
	}
}
