package com.swabhav.bank.repositories;

import java.util.List;

import com.swabhav.bank.entities.Customer;
import com.swabhav.bank.entities.Loan;

public interface LoanRepo {
	List<Loan> getAllLoan();
	Loan getLoan(int loanId);
	void deleteLoan(int loanId);
	void updateLoan(Loan loan);
	void insertLoan(Loan loan);
}
