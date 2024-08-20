package com.swabhav.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swabhav.bank.entities.Customer;
import com.swabhav.bank.repositories.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.getAllCustomer();
	}

	@Override
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerRepo.getCustomer(customerId);
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		customerRepo.deleteCustomer(customerId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.updateCustomer(customer);
	}

	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.insertCustomer(customer);
	}
	
	
}
