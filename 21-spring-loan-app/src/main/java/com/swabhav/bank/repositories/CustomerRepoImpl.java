package com.swabhav.bank.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swabhav.bank.entities.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CustomerRepoImpl implements CustomerRepo{
	
	@Autowired
	EntityManager manager;

	@Override
	public List<Customer> getAllCustomer() {
		TypedQuery<Customer> query = manager.createQuery("select p from Customer p", Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer getCustomer(int customerId) {
		return manager.find(Customer.class, customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		Customer customer = manager.find(Customer.class, customerId);
		manager.remove(customer);		
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		manager.merge(customer);
	}

	@Override
	@Transactional
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		manager.persist(customer);
	}

}