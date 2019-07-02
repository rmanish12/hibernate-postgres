package com.hibernate_postgres.service;

import com.hibernate_postgres.entity.CourseEntity;
import com.hibernate_postgres.entity.StudentEntity;

public interface StudentService {
	public CourseEntity getStudentsForCourse(int courseId);
	public StudentEntity getCoursesForStudent(int studentId) throws Exception;
	public void linkCourseWithStudent(int courseId, int studentId);
	public void insertNewCourse(CourseEntity course);
	public void insertNewStudent(StudentEntity student);
	public void deleteStudent(int studentId);
	public void deleteCourse(int courseId);
}
