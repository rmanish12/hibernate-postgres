package com.hibernate_postgres.service;

import com.hibernate_postgres.dao.StudentDAO;
import com.hibernate_postgres.dao.StudentDAOImpl;
import com.hibernate_postgres.entity.CourseEntity;
import com.hibernate_postgres.entity.StudentEntity;

public class StudentServiceImpl implements StudentService{

	StudentDAO studentdao = new StudentDAOImpl();
	
	public void getStudentsForCourse(int courseId) {
		try {
			studentdao.getStudentsForCourse(courseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCoursesForStudent(int studentId) {
		try {
			studentdao.getCoursesForStudent(studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void linkCourseWithStudent(int courseId, int studentId) {
		try {
			studentdao.linkCourseWithStudent(courseId, studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public void insertNewCourse(CourseEntity course) {
		try {
			studentdao.insertNewCourse(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertNewStudent(StudentEntity student) {
		try {
			studentdao.insertNewStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(int studentId) {
		try {
			studentdao.deleteStudent(studentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCourse(int courseId) {
		try {
			studentdao.deleteCourse(courseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
