package com.swabhav.model;

public class CurrentAccount extends Account{
	private final double OVER_DRAFT_LIMIT;

	public CurrentAccount(String name, double balance, double OVER_DRAFT_LIMIT) {
		super( name, balance);
		this.OVER_DRAFT_LIMIT = OVER_DRAFT_LIMIT;
	}

	public double getOVER_DRAFT_LIMIT() {
		return OVER_DRAFT_LIMIT;
	}

	
	
	
	@Override
	public String toString() {
		return "CurrentAccount details: \n OVER_DRAFT_LIMIT=" + OVER_DRAFT_LIMIT + ",\n AccountNumber=" + getAccountNumber()
				+ ",\n Name=" + getName() + ",\n Balance=" + getBalance();
	}

	public void debit(double amount) {
		if(amount < 0) {
			System.out.println("Amount can't be negative");
			return;
		}
		
        if(this.balance - amount >= -this.OVER_DRAFT_LIMIT) {
            this.balance -= amount;
            System.out.println("Debit of $" + amount + " successful");
            return;
        }
        
        System.out.println("Insufficient funds (including overdraft limit)");
	}
	
	
	
}
