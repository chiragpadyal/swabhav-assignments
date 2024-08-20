package com.swabhav.bank.repositories;

import java.util.List;

import com.swabhav.bank.entities.Payment;

public interface PaymentRepo {
	List<Payment> getAllPayments();
	Payment getPayment(int paymentId);
	void deletePayment(int paymentId);
	void updatePayment(Payment payment);
	void insertPayment(Payment payment);
}
