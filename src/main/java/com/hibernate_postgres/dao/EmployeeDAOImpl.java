package com.hibernate_postgres.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_postgres.bean.BankDetailsBean;
import com.hibernate_postgres.bean.EmployeeBean;
import com.hibernate_postgres.entity.BankEntity;
import com.hibernate_postgres.entity.EmployeeEntity;
import com.hibernate_postgres.exceptions.BankAccountExists;
import com.hibernate_postgres.exceptions.EmployeeAlreadyExists;
import com.hibernate_postgres.exceptions.EmployeeNotFound;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	public void getEmployeeDetails(EmployeeBean employee) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(EmployeeEntity.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		EmployeeEntity emp = null;
		
		try {
			
			session.beginTransaction();
			
			emp = session.get(EmployeeEntity.class, employee.getEmployeeNumber());
			
			if(emp!=null) {
				EmployeeBean employeeToFetch = new EmployeeBean();
				
				BankDetailsBean details = new BankDetailsBean();
				details.setBankAccount(emp.getBankAccount().getBankAccount());
				details.setSalary(emp.getBankAccount().getSalary());
				
				employeeToFetch.setEmployeeNumber(emp.getEmployeeNumber());
				employeeToFetch.setEmployeeName(emp.getEmployeeName());
				employeeToFetch.setBankAccount(details);
				employeeToFetch.setDepartmentNumber(emp.getDepartmentNumber());
				employeeToFetch.setJob(emp.getJob());
				employeeToFetch.setManager(emp.getManager());
				
				logger.info("Employee fetched");
			} else {
				throw new EmployeeNotFound("Could not find. Employee does not exists");
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	public void updateSalary(BankDetailsBean bankDetail, int salary) throws Exception {
		
		SessionFactory sesisonFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(BankEntity.class).buildSessionFactory();
		
		Session session = sesisonFactory.getCurrentSession();
		
		BankEntity updatedDetail = null;
		
		try {
			
			session.beginTransaction();
			
			updatedDetail = session.get(BankEntity.class, bankDetail.getBankAccount());
			
			if(updatedDetail!=null) {
				updatedDetail.setSalary(salary);
				
				session.save(updatedDetail);
				session.getTransaction().commit();
				
				logger.info("Record updated successfully");
			} else {
				throw new EmployeeNotFound("Could not update. Employee does not exists");
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		
	}
	
	public void insertEmployee(EmployeeBean employee, BankDetailsBean bankDetails) throws Exception {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		BankEntity bank = null;
		EmployeeEntity emp = null;
		
		try {
			
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(BankEntity.class).buildSessionFactory();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			bank = session.get(BankEntity.class, bankDetails.getBankAccount());
			
			if(bank==null) {
				bank = new BankEntity();
				
				bank.setBankAccount(bankDetails.getBankAccount());
				bank.setSalary(bankDetails.getSalary());
				
				session.save(bank);
				session.getTransaction().commit();
				
				logger.info("Bank detail inserted successfully..");
			} else {
				throw new BankAccountExists("Could not insert. This bank account number is already in use.");
			}
						
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(EmployeeEntity.class).buildSessionFactory();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			emp = session.get(EmployeeEntity.class, employee.getEmployeeNumber());
			
			if(emp==null) {
				emp = new EmployeeEntity();
				
				emp.setEmployeeNumber(employee.getEmployeeNumber());
				emp.setEmployeeName(employee.getEmployeeName());
				emp.setBankAccount(bank);
				emp.setDepartmentNumber(employee.getDepartmentNumber());
				emp.setJob(employee.getJob());
				emp.setManager(employee.getManager());
				
				session.save(emp);
				session.getTransaction().commit();
				
				logger.info("Employee inserted successfully..");
			} else {
				throw new EmployeeAlreadyExists("Cannot insert this employee. This employee number is already taken.");
			}
			
		} catch (Exception e) {
			logger.error(e);
			throw(e);
		}
	}
	
	public void deteteEmployee(EmployeeBean employee) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(EmployeeEntity.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		EmployeeEntity emp = null;
		
		try {
			session.beginTransaction();
			
			emp = session.get(EmployeeEntity.class, employee.getEmployeeNumber());
			
			if(emp!=null) {			
				session.delete(emp);
				session.getTransaction().commit();
				
				logger.info("Employee record deleted..");
			} else {
				throw new EmployeeNotFound("Could not delete. Employee does not exist.");
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
}
