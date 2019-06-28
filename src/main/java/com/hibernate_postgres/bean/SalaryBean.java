package com.hibernate_postgres.bean;

public class SalaryBean {

	private int bankAccountNumber;
	private int salary;
	private EmployeeBean employee;
	
	public int getBankAccountNumber() {
		return bankAccountNumber;
	}
	
	public void setBankAccountNumber(int bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public EmployeeBean getEmployee() {
		return employee;
	}
	
	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "SalaryBean [bankAccountNumber=" + bankAccountNumber + ", salary=" + salary + ", employee=" + employee
				+ "]";
	}
	
}
