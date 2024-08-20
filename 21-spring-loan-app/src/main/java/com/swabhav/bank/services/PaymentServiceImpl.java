package com.swabhav.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swabhav.bank.entities.Payment;
import com.swabhav.bank.repositories.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepo paymentRepo;
	
	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentRepo.getAllPayments();
	}

	@Override
	public Payment getPayment(int paymentId) {
		// TODO Auto-generated method stub
		return paymentRepo.getPayment(paymentId);
	}

	@Override
	public void deletePayment(int paymentId) {
		// TODO Auto-generated method stub
		paymentRepo.deletePayment(paymentId);
	}

	@Override
	public void updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		paymentRepo.updatePayment(payment);
	}

	@Override
	public void insertPayment(Payment payment) {
		// TODO Auto-generated method stub
		paymentRepo.insertPayment(payment);
	}

}
