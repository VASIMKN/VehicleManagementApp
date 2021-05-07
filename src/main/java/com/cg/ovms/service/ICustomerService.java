package com.cg.ovms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Customer;

@Service
public interface ICustomerService {

	public Customer addCustomer(Customer customer);

	public Customer removeCustomer(Customer customer);

	public Customer viewCustomer(Customer c);

	public Customer updateCustomer(Customer c);

	public List<Customer> viewAllCustomer(String vtype);

	public List<Customer> viewAllCustomersByLocation(String location);
	
	
}
