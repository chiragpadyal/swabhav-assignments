package com.swabhav.bank.services;

import java.util.List;

import com.swabhav.bank.entities.Customer;
public interface CustomerService {
	List<Customer> getAllCustomer();
	Customer getCustomer(int customerId);
	void deleteCustomer(int customerId);
	void updateCustomer(Customer customer);
	void insertCustomer(Customer customer);
	List<Customer> findCustomers(Customer customer);

}
