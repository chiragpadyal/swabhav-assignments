package com.swabhav.bank.services;

import java.util.List;

import com.swabhav.bank.entities.Loan;

public interface LoanService {
	List<Loan> getAllLoan();
	Loan getLoan(int loanId);
	void deleteLoan(int loanId);
	void updateLoan(Loan loan);
	void insertLoan(Loan loan);
}
