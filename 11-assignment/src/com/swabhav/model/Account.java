package com.swabhav.model;

import java.util.Random;

import com.swabhav.exception.AccountException;


public class Account {
	protected final long accountNumber;
	protected String name;
	protected double balance;
	
	public Account(String name, double balance) {
		this.accountNumber = this.randomAccountNumber();
		this.name = name;
		this.balance = balance;
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
	
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void credit(double amount) {
		if(amount > 0) {
			this.balance += amount;
			return;
		}
		throw new AccountException("Amount can't be negative");
	}
	
	public void debit(double amount) {
		if(amount < 0) {
			throw new AccountException("Amount can't be negative");
		}
		if(this.balance >= amount) {
			this.balance = balance - amount;
			return;
		}
		throw new AccountException("Insuffient Balance");
	}

	@Override
	public String toString() {
		return "Account details \n accountNumber=" + accountNumber + ",\n name=" + name + ",\n balance=" + balance;
	}
}
