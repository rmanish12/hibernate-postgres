package com.hibernate_postgres.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bank_details")
public class SalaryEntity {

	@Id
	@Column(name = "bank_account")
	private int bankAccountNumber;
	
	private int salary;
	
	@OneToOne(mappedBy = "bankAccount", cascade = CascadeType.ALL)
	private EmployeeEntity employee;

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

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
		
}
