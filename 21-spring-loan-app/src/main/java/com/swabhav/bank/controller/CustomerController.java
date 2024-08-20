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

import com.swabhav.bank.entities.Loan;
import com.swabhav.bank.services.CustomerService;

@RestController
@RequestMapping("bank")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("customers")
	public ResponseEntity<List<Loan>> getAllCustomers() {
		return ResponseEntity.ok(customerService.getAllCustomer());
	}
	
	@GetMapping("customer/{customerId}")
	public ResponseEntity<Loan> getCustomer(@PathVariable int customerId){
		return ResponseEntity.ok(customerService.getCustomer(customerId));
	}
	
	@DeleteMapping("customer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId){
		customerService.deleteCustomer(customerId);
		return ResponseEntity.ok("done");
	}
	
	@PutMapping("customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Loan customer){
		customerService.updateCustomer(customer);
		return ResponseEntity.ok("done");
	}
	
	@PostMapping("customer")
	public ResponseEntity<String> insertCustomer(@RequestBody Loan customer){
		customerService.insertCustomer(customer);
		return ResponseEntity.ok("done");
	}
	
	
	
	
}
