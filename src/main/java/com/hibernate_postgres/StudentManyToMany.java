package com.hibernate_postgres;

import com.hibernate_postgres.service.StudentService;
import com.hibernate_postgres.service.StudentServiceImpl;

public class StudentManyToMany {
	
	public static void main(String[] args) {
		StudentService studentService = new StudentServiceImpl();
//		studentService.getStudentsForCourse(10);
		
//		studentService.getCoursesForStudent(2);
		
		studentService.linkCourseWithStudent(10, 7);
		
//		CourseEntity course = new CourseEntity();
//		course.setId(12);
//		course.setName("How to solve Rubik's cube faster");
//		studentService.insertNewCourse(course);
		
//		StudentEntity student = new StudentEntity();
//		student.setId(36);
//		student.setName("Reppy Red");
//		student.setMark(29);
//		student.setSex("male");
//		student.setGrade("Four");
//		studentService.insertNewStudent(student);
		
//		studentService.deleteStudent(2);
		
//		studentService.deleteCourse(10);
	}
}