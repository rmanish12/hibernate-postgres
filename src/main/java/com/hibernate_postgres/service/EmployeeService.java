package com.hibernate_postgres.service;

import com.hibernate_postgres.bean.BankDetailsBean;
import com.hibernate_postgres.bean.EmployeeBean;

public interface EmployeeService {
	public void getEmployeeDetails(EmployeeBean employee);
	public void updateSalary(BankDetailsBean bankDetail, int salary);
	public void insertEmployee(EmployeeBean employee, BankDetailsBean bankDetails);
	public void deteteEmployee(EmployeeBean employee);
}
