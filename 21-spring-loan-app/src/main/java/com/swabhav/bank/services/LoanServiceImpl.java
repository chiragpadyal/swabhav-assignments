package com.swabhav.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swabhav.bank.entities.Loan;
import com.swabhav.bank.repositories.LoanRepo;
@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	LoanRepo loanRepo;

	@Override
	public List<Loan> getAllLoan() {
		// TODO Auto-generated method stub
		return loanRepo.getAllLoan();
	}

	@Override
	public Loan getLoan(int loanId) {
		// TODO Auto-generated method stub
		return loanRepo.getLoan(loanId);
	}

	@Override
	public void deleteLoan(int loanId) {
		// TODO Auto-generated method stub
		loanRepo.deleteLoan(loanId);
	}

	@Override
	public void updateLoan(Loan loan) {
		// TODO Auto-generated method stub
		loanRepo.updateLoan(loan);
	}

	@Override
	public void insertLoan(Loan loan) {
		// TODO Auto-generated method stub
		loanRepo.insertLoan(loan);
	}
	
	
}
