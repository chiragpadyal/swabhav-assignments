package com.swabhav.model;

import com.swabhav.exception.AccountException;

public class SavingsAccount extends Account{
	private final double MIN_BALANCE;

	public SavingsAccount(String name, double balance, double MIN_BALANCE) {
		super(name, balance);
		this.MIN_BALANCE = MIN_BALANCE;
	}

	public double getMIN_BALANCE() {
		return MIN_BALANCE;
	}

	@Override
	public String toString() {
		return "SavingsAccount details: \n MIN_BALANCE=" + MIN_BALANCE + ",\n AccountNumber=" + getAccountNumber()
				+ ",\n Name=" + getName() + ",\n Balance=" + getBalance();
	}
	
	@Override
	public void debit(double amount) {
		if(this.getBalance() <= MIN_BALANCE) {
			throw new AccountException("Can't withdraw below minimum balance");
		};
		super.debit(amount);
	}
	
	
	
	
	
}
