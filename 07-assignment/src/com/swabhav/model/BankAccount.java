package com.swabhav.model;

import java.util.Random;

public class BankAccount {
	private long accountNumber;
	private String name;
	private double balance;
	private AccountType accountType;
	

	

	public BankAccount(String name, double balance, AccountType accountType) {
		this.accountNumber = this.randomAccountNumber();
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}


	
	private long randomAccountNumber() {
		long accountNumberCopy = 0;
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			accountNumberCopy += rand.nextInt(10);
			if(i != 9) accountNumberCopy *= 10;
		}
		return accountNumberCopy;
	}
	
	public void credit(double amount) {
		if(amount > 0) {
			this.balance += amount;
		} else {
			System.out.println("Amount can't be negative");
		}
	}
	
	public void debit(double amount) {
		if(amount < 0) System.out.println("Amount can't be negative");
		if(this.balance >= amount) {
			this.balance = balance - amount;
		}else {
			System.out.println("Insuffient Balance");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length() > 1)
		this.name = name;
	}

	public double getBalance() {
		
		return balance;
	}

	public void setBalance(double balance) {
		if(balance >= 0) this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	
	@Override
	public String toString() {
		return "Account Details: \n accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance
				+ ", accountType=" + accountType + " ";
	}
	
	
}
