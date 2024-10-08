package com.swabhav.bank.repositories;

import java.util.List;

import com.swabhav.bank.entities.Customer;

public interface CustomerRepo {
	List<Customer> getAllCustomer();
	Customer getCustomer(int customerId);
	List<Customer> findCustomers(Customer customer);
	void deleteCustomer(int customerId);
	void updateCustomer(Customer customer);
	void insertCustomer(Customer customer);
}
