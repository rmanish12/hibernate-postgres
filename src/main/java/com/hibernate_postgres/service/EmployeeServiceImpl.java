package com.hibernate_postgres.service;

import com.hibernate_postgres.bean.BankDetailsBean;
import com.hibernate_postgres.bean.EmployeeBean;
import com.hibernate_postgres.dao.EmployeeDAO;
import com.hibernate_postgres.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDAO emp = new EmployeeDAOImpl();
	
	public void getEmployeeDetails(EmployeeBean employee) {
		try {
			emp.getEmployeeDetails(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSalary(BankDetailsBean bankDetail, int salary) {
		try {
			emp.updateSalary(bankDetail, salary);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void insertEmployee(EmployeeBean employee, BankDetailsBean bankDetails) {
		try {
			emp.insertEmployee(employee, bankDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void deteteEmployee(EmployeeBean employee) {
		try {
			emp.deteteEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
