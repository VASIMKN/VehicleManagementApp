package com.cg.ovms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Customer;
import com.cg.ovms.repository.ICustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService{

	@Autowired
	ICustomerRepository customerRepository;
	
	
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomer(String vtype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomersByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
