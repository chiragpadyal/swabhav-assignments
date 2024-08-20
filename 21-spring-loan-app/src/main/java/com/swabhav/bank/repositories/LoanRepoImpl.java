package com.swabhav.bank.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swabhav.bank.entities.Loan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class LoanRepoImpl implements LoanRepo {
	@Autowired
	EntityManager manager;
	@Override
	public List<Loan> getAllLoan() {
			TypedQuery<Loan> query = manager.createQuery("select p from Loan p", Loan.class);
			return query.getResultList();
	}

	@Override
	public Loan getLoan(int loanId) {
		return manager.find(Loan.class, loanId);
	}

	@Override
	@Transactional
	public void deleteLoan(int loanId) {
		// TODO Auto-generated method stub
		Loan loan = manager.find(Loan.class, loanId);
		manager.remove(loan);
	}

	@Override
	@Transactional
	public void updateLoan(Loan loan) {
		// TODO Auto-generated method stub
		manager.merge(loan);
	}

	@Override
	@Transactional
	public void insertLoan(Loan loan) {
		// TODO Auto-generated method stub
		manager.persist(loan);
	}

}
