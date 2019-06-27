package com.hibernate_postgres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_details")
public class BankEntity {

	@Id
	@Column(name = "bank_account")
	private int bankAccount;
	
	private int salary;

	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "BankEntity [bankAccount=" + bankAccount + ", salary=" + salary + "]";
	}

}
