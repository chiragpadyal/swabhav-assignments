package com.swabhav.bank.repositories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Customer oldCustomer = this.getCustomer(customer.getCustomerId());	
		if(oldCustomer != null) {	
			if(customer.getDateOfBirth() == null) customer.setDateOfBirth(oldCustomer.getDateOfBirth());
			if(customer.getEmailId() == null) customer.setEmailId(oldCustomer.getEmailId());
			if(customer.getFirstName() == null) customer.setFirstName(oldCustomer.getFirstName());
			if(customer.getLastName() == null) customer.setLastName(oldCustomer.getLastName());
			if(customer.getMobileNumber() == null) customer.setMobileNumber(oldCustomer.getMobileNumber());
			manager.merge(customer);
		}
	}

	@Override
	@Transactional
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		manager.persist(customer);
	}

	@Override
	public List<Customer> findCustomers(Customer customer) {
	    if (customer.getCustomerId() != 0) {
	        return Arrays.asList(this.getCustomer(customer.getCustomerId()));
	    }

	    StringBuilder queryBuilder = new StringBuilder("SELECT c FROM Customer c WHERE 1=1");
	    Map<String, Object> parameters = new HashMap<>();

	    if (customer.getDateOfBirth() != null) {
	        queryBuilder.append(" AND c.dateOfBirth = :dateOfBirth");
	        parameters.put("dateOfBirth", customer.getDateOfBirth());
	    }
	    if (customer.getEmailId() != null) {
	        queryBuilder.append(" AND c.emailId = :emailId");
	        parameters.put("emailId", customer.getEmailId());
	    }
	    if (customer.getFirstName() != null) {
	        queryBuilder.append(" AND c.firstName = :firstName");
	        parameters.put("firstName", customer.getFirstName());
	    }
	    if (customer.getLastName() != null) {
	        queryBuilder.append(" AND c.lastName = :lastName");
	        parameters.put("lastName", customer.getLastName());
	    }
	    if (customer.getMobileNumber() != null) {
	        queryBuilder.append(" AND c.mobileNumber = :mobileNumber");
	        parameters.put("mobileNumber", customer.getMobileNumber());
	    }

	    // Create the query
	    TypedQuery<Customer> query = manager.createQuery(queryBuilder.toString(), Customer.class);

	    // Set the parameters
	    for (Map.Entry<String, Object> entry : parameters.entrySet()) {
	        query.setParameter(entry.getKey(), entry.getValue());
	    }

	    // Return the result
	    List<Customer> results = query.getResultList();
	    return results;
	}


}