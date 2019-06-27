package com.hibernate_postgres.bean;

public class BankDetailsBean {

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
		return "BankDetailsBean [bankAccount=" + bankAccount + ", salary=" + salary + "]";
	}

}
