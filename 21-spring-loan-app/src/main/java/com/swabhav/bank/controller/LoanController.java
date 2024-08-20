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

import com.swabhav.bank.entities.Customer;
import com.swabhav.bank.services.LoanService;

@RestController
@RequestMapping("bank")
public class LoanController {

	@Autowired
	LoanService loanService;
	
	@GetMapping("loans")
	public ResponseEntity<List<Customer>> getAllLoans() {
		return ResponseEntity.ok(loanService.getAllLoan());
	}
	
	@GetMapping("loan/{loanId}")
	public ResponseEntity<Customer> getLoan(@PathVariable int loanId){
		return ResponseEntity.ok(loanService.getLoan(loanId));
	}
	
	@DeleteMapping("loan/{loanId}")
	public ResponseEntity<String> deleteLoan(@PathVariable int loanId){
		loanService.deleteLoan(loanId);
		return ResponseEntity.ok("done");
	}
	
	@PutMapping("loan")
	public ResponseEntity<String> updateLoan(@RequestBody Customer loan){
		loanService.updateLoan(loan);
		return ResponseEntity.ok("done");
	}
	
	@PostMapping("loan")
	public ResponseEntity<String> insertLoan(@RequestBody Customer loan){
		loanService.insertLoan(loan);
		return ResponseEntity.ok("done");
	}
	
	
	
	
}
