package com.hibernate_postgres;

import com.hibernate_postgres.bean.BankDetailsBean;
import com.hibernate_postgres.bean.EmployeeBean;
import com.hibernate_postgres.service.EmployeeService;
import com.hibernate_postgres.service.EmployeeServiceImpl;

public class EmployeeOneToOne {

	public static void main(String[] args) {
		
		EmployeeBean emp = new EmployeeBean();
		BankDetailsBean bank = new BankDetailsBean();
		EmployeeService empService = new EmployeeServiceImpl();
		
		//GET employee detail
//		emp.setEmployeeNumber(7788);
//		empService.getEmployeeDetails(emp);
//		
		//UPDATE salary
//		bank.setBankAccount(56789);
//		
//		int salary = 60000;
//		empService.updateSalary(bank, salary);
		
		//INSERT new employee
//		bank.setBankAccount(98765);
//		bank.setSalary(70000);
//		
//		emp.setBankAccount(bank);
//		emp.setDepartmentNumber(10);
//		emp.setEmployeeName("MICHAEL");
//		emp.setEmployeeNumber(7985);
//		emp.setJob("ANALYST");
//		emp.setManager(0000);
//		
//		empService.insertEmployee(emp, bank);
		
		//DELETE user
		emp.setEmployeeNumber(7985);
		empService.deteteEmployee(emp);
	}
	
}
