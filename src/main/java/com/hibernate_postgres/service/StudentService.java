package com.hibernate_postgres.service;

import com.hibernate_postgres.entity.CourseEntity;
import com.hibernate_postgres.entity.StudentEntity;

public interface StudentService {
	public void getStudentsForCourse(int courseId);
	public void getCoursesForStudent(int studentId);
	public void linkCourseWithStudent(int courseId, int studentId);
	public void insertNewCourse(CourseEntity course);
	public void insertNewStudent(StudentEntity student);
	public void deleteStudent(int studentId);
	public void deleteCourse(int courseId);
}
