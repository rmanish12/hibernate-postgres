package com.hibernate_postgres.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_postgres.entity.CourseEntity;
import com.hibernate_postgres.entity.StudentEntity;

public class StudentDAOImpl implements StudentDAO{

	static Logger logger = Logger.getLogger(StudentDAOImpl.class);
	
	public void getStudentsForCourse(int courseId) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(CourseEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		CourseEntity course = null;
		
		try {
			
			session.beginTransaction();
			
			course = session.get(CourseEntity.class, courseId);
			
			if(course!=null) {
				if(course.getStudents().size()!=0) {
					for(StudentEntity s: course.getStudents()) {
						logger.info(s.getId());
					}
				}
			} else {
				logger.warn("Course not found");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void getCoursesForStudent(int studentId) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(StudentEntity.class)
											.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		StudentEntity student = null;
		
		try {
			session.beginTransaction();
			
			student = session.get(StudentEntity.class, studentId);
			
			if(student!=null) {
				if(student.getCourses().size()!=0) {
					for(CourseEntity c: student.getCourses()) {
						logger.info(c.getId());
					}
				}
			} else {
				logger.warn("Student not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
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
				logger.error("Course not found");
			}
		} catch (Exception e) {
			// TODO: handle exception
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
				logger.warn("Course already exists");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
				logger.error("Student already exists");
			}
		} catch (Exception e) {
			// TODO: handle exception
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
				logger.error("Student does not exist");
			}
		} catch (Exception e) {
			// TODO: handle exception
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
				logger.error("Course does not exist");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
