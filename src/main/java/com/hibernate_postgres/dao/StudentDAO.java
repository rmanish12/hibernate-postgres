package com.hibernate_postgres.dao;

import com.hibernate_postgres.entity.CourseEntity;
import com.hibernate_postgres.entity.StudentEntity;

public interface StudentDAO {

	public void getStudentsForCourse(int courseId) throws Exception;
	public void getCoursesForStudent(int studentId) throws Exception;
	public void linkCourseWithStudent(int courseId, int studentId) throws Exception;
	public void insertNewCourse(CourseEntity course) throws Exception;
	public void insertNewStudent(StudentEntity student) throws Exception;
	public void deleteStudent(int studentId) throws Exception;
	public void deleteCourse(int courseId) throws Exception;
	
}
