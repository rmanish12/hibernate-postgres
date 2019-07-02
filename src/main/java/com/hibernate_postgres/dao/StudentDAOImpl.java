package com.hibernate_postgres.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_postgres.entity.CourseEntity;
import com.hibernate_postgres.entity.StudentEntity;
import com.hibernate_postgres.exceptions.CourseAlreadyExists;
import com.hibernate_postgres.exceptions.CourseNotFound;
import com.hibernate_postgres.exceptions.StudentAlreadyExists;
import com.hibernate_postgres.exceptions.StudentNotFound;

public class StudentDAOImpl implements StudentDAO{

	static Logger logger = Logger.getLogger(StudentDAOImpl.class);
	
	public CourseEntity getStudentsForCourse(int courseId) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(CourseEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		CourseEntity course = null;
		
		try {
			
			session.beginTransaction();
			
			course = session.get(CourseEntity.class, courseId);
			
			if(course!=null) {
				
			} else {
				throw new CourseNotFound("Course not found");
			}
						
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		
		return course;
	}
	
	public StudentEntity getCoursesForStudent(int studentId) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(StudentEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		StudentEntity student = null;
		
		try {
			session.beginTransaction();
			
			student = session.get(StudentEntity.class, studentId);
			
			if(student!=null) {
				
			} else {
				throw new StudentNotFound("Student not found");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		
		return student;
	}
	
	public void linkCourseWithStudent(int courseId, int studentId) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(CourseEntity.class)
											.addAnnotatedClass(StudentEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		CourseEntity course = null;
		StudentEntity student = null;
		
		try {
			session.beginTransaction();
			
			course = session.get(CourseEntity.class, courseId);
			
			if(course!=null) {
				student = session.get(StudentEntity.class, studentId);
				
				course.add(student);
				
				session.save(course);
				session.getTransaction().commit();
				
				logger.info("Student added to the course");
			} else {
				throw new CourseNotFound("Course not found");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public void insertNewCourse(CourseEntity course) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(CourseEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		CourseEntity newCourse = null;
		
		try {
			session.beginTransaction();
			
			newCourse = session.get(CourseEntity.class, course.getId());
			
			if(newCourse==null) {
				session.save(course);
				session.getTransaction().commit();
				
				logger.info("Course inserted successfully..");
			} else {
				throw new CourseAlreadyExists("Course already exists");
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public void insertNewStudent(StudentEntity student) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(StudentEntity.class)
											.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		StudentEntity newStudent = null;
		
		try {
			session.beginTransaction();
			
			newStudent = session.get(StudentEntity.class, student.getId());
			
			if(newStudent==null) {
				session.save(student);
				session.getTransaction().commit();
				
				logger.info("Student saved successfully");
			} else {
				throw new StudentAlreadyExists("Student already exists");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public void deleteStudent(int studentId) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(StudentEntity.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		
		StudentEntity student = null;
		
		try {
			session.beginTransaction();
			
			student = session.get(StudentEntity.class, studentId);
			
			if(student!=null) {
				session.delete(student);
				session.getTransaction().commit();
				
				logger.info("Student record deleted successfully");
			} else {
				throw new StudentNotFound("Student does not exist");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public void deleteCourse(int courseId) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(CourseEntity.class)
											.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		CourseEntity course = null;
		
		try {
			session.beginTransaction();
			
			course = session.get(CourseEntity.class, courseId);
			
			if(course!=null) {
				session.delete(course);
				session.getTransaction().commit();
				
				logger.info("Course deleted successfully");
			} else {
				throw new CourseNotFound("Course does not exist");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
}
