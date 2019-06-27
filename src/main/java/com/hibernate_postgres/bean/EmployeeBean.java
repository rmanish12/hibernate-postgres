package com.hibernate_postgres.bean;

public class EmployeeBean {

	private int employeeNumber;
	private String employeeName;
	private String job;
	private int manager;
	private BankDetailsBean bankAccount;
	private int departmentNumber;
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public BankDetailsBean getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankDetailsBean bankAccount) {
		this.bankAccount = bankAccount;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	
	@Override
	public String toString() {
		return "EmployeeBean [employeeNumber=" + employeeNumber + ", employeeName=" + employeeName + ", job=" + job
				+ ", manager=" + manager + ", bankAccount=" + bankAccount + ", departmentNumber=" + departmentNumber
				+ "]";
	}
			
}
