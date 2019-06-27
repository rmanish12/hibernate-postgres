package com.hibernate_postgres.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

	@Id
	@Column(name = "emp_no")
	private int employeeNumber;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	
	private String job;
	private int manager;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_account")
	private BankEntity bankAccount;
		
	@Column(name = "dept_no")
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

	public BankEntity getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankEntity bankAccount) {
		this.bankAccount = bankAccount;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

}
