package com.hibernate_postgres;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.hibernate_postgres.dao.StudentDAO;
import com.hibernate_postgres.dao.StudentDAOImpl;
import com.hibernate_postgres.entity.CourseEntity;
import com.hibernate_postgres.entity.StudentEntity;
import com.hibernate_postgres.exceptions.CourseAlreadyExists;
import com.hibernate_postgres.exceptions.CourseNotFound;
import com.hibernate_postgres.exceptions.StudentAlreadyExists;
import com.hibernate_postgres.exceptions.StudentNotFound;

public class StudentManyToManyTest {
	
	private static StudentDAO studentdao;
	private static CourseEntity course;
	private static StudentEntity student;
	
	@BeforeClass
	public static void setup() {
		studentdao = new StudentDAOImpl();
		course = new CourseEntity();
		student = new StudentEntity();
	}

	@Test()
	public void testGetStudentsForCourse() throws Exception {	
		course = studentdao.getStudentsForCourse(12);
		
		assertEquals(2, course.getStudents().size());
		assertEquals(3, course.getStudents().get(0).getId());
		assertEquals(4, course.getStudents().get(1).getId());
	}
	
	@Test(expected=CourseNotFound.class)
	public void testGetStudentsForCourseException() throws Exception {
		course = studentdao.getStudentsForCourse(15);
		
		assertEquals(2, course.getStudents().size());
	}
	
	@Test
	public void testGetCoursesForStudent() throws Exception {
		student = studentdao.getCoursesForStudent(3);
		
		assertEquals(1, student.getCourses().size());
		assertEquals(12, student.getCourses().get(0).getId());
	}
	
	@Test(expected=StudentNotFound.class)
	public void testGetCoursesForStudentException() throws Exception {
		student = studentdao.getCoursesForStudent(40);
		
		assertEquals(1, student.getCourses().size());
		assertEquals(12, student.getCourses().get(0).getId());
	}
	
//	@Test
//	public void testLinkCourseWithStudent() throws Exception {
//		studentdao.linkCourseWithStudent(11, 7);
//		
//		course = studentdao.getStudentsForCourse(11);
//		
//		assertEquals(7, course.getStudents().get(course.getStudents().size()-1).getId());
//	}
	
	@Test(expected = CourseNotFound.class)
	public void testLinkCourseWithStudentException() throws Exception {
		studentdao.linkCourseWithStudent(15, 7);
		
		course = studentdao.getStudentsForCourse(10);
		
		assertEquals(7, course.getStudents().get(course.getStudents().size()-1).getId());
	}
	
//	@Test
//	public void testInsertNewCourse() throws Exception {
//		CourseEntity course = new CourseEntity();
//		course.setId(10);
//		course.setName("Master of Accountancy - Research");
//		
//		studentdao.insertNewCourse(course);
//		
//		course = studentdao.getStudentsForCourse(10);
//		
//		assertEquals("Master of Accountancy - Research", course.getName());
//	}
	
	@Test(expected=CourseAlreadyExists.class)
	public void testInsertNewCourseException() throws Exception {
		CourseEntity course = new CourseEntity();
		course.setId(11);
		course.setName("Doctor of Philosophy Doctor of Education");
		
		studentdao.insertNewCourse(course);
		
		course = studentdao.getStudentsForCourse(11);
		
		assertEquals("Doctor of Philosophy Doctor of Education", course.getName());
	}

	@Test
	public void testInsertNewStudent() throws Exception {
		StudentEntity student = new StudentEntity();
		student.setId(37);
		student.setGrade("five");
		student.setMark(89);
		student.setName("Michael");
		student.setSex("male");
		
		studentdao.insertNewStudent(student);
		
		student = studentdao.getCoursesForStudent(37);
		
		assertEquals("Michael", student.getName());
	}
	
//	@Test(expected=StudentAlreadyExists.class)
//	public void testInsertNewStudentException() throws Exception {
//		StudentEntity student = new StudentEntity();
//		student.setId(37);
//		student.setGrade("five");
//		student.setMark(89);
//		student.setName("Michael");
//		student.setSex("male");
//		
//		studentdao.insertNewStudent(student);
//		
//		student = studentdao.getCoursesForStudent(37);
//		
//		assertEquals("Michael", student.getName());
//	}
	
	@Test(expected=StudentNotFound.class)
	public void testDeleteStudent() throws Exception {
		studentdao.deleteStudent(37);
		
		student = studentdao.getCoursesForStudent(37);
	}
	
	@Test(expected=StudentNotFound.class)
	public void testDeleteStudentException() throws Exception {
		studentdao.deleteStudent(307);
		
		student = studentdao.getCoursesForStudent(307);
	}
	
	@Test(expected=CourseNotFound.class)
	public void testDeleteCourse() throws Exception {
		studentdao.deleteCourse(10);
		
		course = studentdao.getStudentsForCourse(10);
	}
	
	@Test(expected=CourseNotFound.class)
	public void testDeleteCourseException() throws Exception {
		studentdao.deleteCourse(100);
		
		course = studentdao.getStudentsForCourse(100);
	}
}
