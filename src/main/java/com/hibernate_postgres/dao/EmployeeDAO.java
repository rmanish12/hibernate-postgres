package com.hibernate_postgres.dao;

import com.hibernate_postgres.bean.BankDetailsBean;
import com.hibernate_postgres.bean.EmployeeBean;

public interface EmployeeDAO {
	public void getEmployeeDetails(EmployeeBean employee) throws Exception;
	public void updateSalary(BankDetailsBean bankDetail, int salary) throws Exception;
	public void insertEmployee(EmployeeBean employee, BankDetailsBean bankDetails) throws Exception;
	public void deteteEmployee(EmployeeBean employee) throws Exception;
}
