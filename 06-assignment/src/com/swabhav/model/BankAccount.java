package com.swabhav.model;

import java.util.Random;

public class BankAccount {
	private final long accountNumber;
	private String name;
	private double balance;
	
	public BankAccount() {
		long accountNumberCopy = 0;
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			accountNumberCopy += rand.nextInt(10);
			if(i != 9) accountNumberCopy *= 10;
		}
		this.accountNumber = accountNumberCopy;
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
	
}
