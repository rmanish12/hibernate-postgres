package com.hibernate_postgres.exceptions;

@SuppressWarnings("serial")
public class CourseNotFound extends RuntimeException{
	public CourseNotFound(String errorMessage) {
		super(errorMessage);
	}
}
