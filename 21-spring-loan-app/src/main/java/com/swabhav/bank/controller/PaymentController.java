package com.swabhav.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.bank.entities.Payment;
import com.swabhav.bank.services.PaymentService;

@RestController
@RequestMapping("bank")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping("payments")
	public ResponseEntity<List<Payment>> getAllPayments() {
		return ResponseEntity.ok(paymentService.getAllPayments());
	}
	
	@GetMapping("payment/{paymentId}")
	public ResponseEntity<Payment> getPayment(@PathVariable int paymentId){
		return ResponseEntity.ok(paymentService.getPayment(paymentId));
	}
	
	@DeleteMapping("payment/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable int paymentId){
		paymentService.deletePayment(paymentId);
		return ResponseEntity.ok("done");
	}
	
	@PutMapping("payment")
	public ResponseEntity<String> updatePayment(@RequestBody Payment payment){
		paymentService.updatePayment(payment);
		return ResponseEntity.ok("done");
	}
	
	@PostMapping("payment")
	public ResponseEntity<String> insertPayment(@RequestBody Payment payment){
		paymentService.insertPayment(payment);
		return ResponseEntity.ok("done");
	}
	
	
	
	
}
