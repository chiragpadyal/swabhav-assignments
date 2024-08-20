package com.swabhav.bank.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swabhav.bank.entities.Payment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PaymentRepoImpl implements PaymentRepo{
	
	@Autowired
	EntityManager manager;

	@Override
	public List<Payment> getAllPayments() {
		TypedQuery<Payment> query = manager.createQuery("select p from Payment p", Payment.class);
		return query.getResultList();
	}

	@Override
	public Payment getPayment(int paymentId) {
		return manager.find(Payment.class, paymentId);
	}

	@Override
	@Transactional
	public void deletePayment(int paymentId) {
		Payment payment = manager.find(Payment.class, paymentId);
		manager.remove(payment);
	}

	@Override
	@Transactional
	public void updatePayment(Payment payment) {
		manager.merge(payment);
	}
	
	@Override
	@Transactional
	public void insertPayment(Payment payment) {
		manager.persist(payment);
	}

}