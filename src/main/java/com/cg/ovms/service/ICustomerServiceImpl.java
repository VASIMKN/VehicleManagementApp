package com.cg.ovms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.repository.ICustomerRepository;


@Service
public class ICustomerServiceImpl implements ICustomerService{

	private static final Logger logger = LoggerFactory.getLogger(ICustomerServiceImpl.class);
	@Autowired
	ICustomerRepository customerRepository;
	@Autowired
	IBookingService bookingService;
	@Autowired
	IVehicleService vehicleService;
	
	//1st method..... taking customer as parameter and doing add customer operation
	@Override
	@Transactional
	
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer c =customerRepository.save(customer);
		
		logger.info("result of addCustomer method : "+customer);
		return c;
	}
    //2nd method... taking customer id as parameter as doing remove operation
	@Override
	@Transactional
	public Customer removeCustomer(int id) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(id).get();
		customerRepository.delete(customer);
		logger.info("Inside removeCustomer method and delete operation has done");
		return customer;
	}



	//3rd method.....taking customer as parameter and doing update operation
	@Override
	@Transactional
	public Customer updateCustomer(Customer c) {
		
		Customer customer = customerRepository.saveAndFlush(c);
		logger.info("resulted customer in updateCustomer method: "+ customer);
			return customer;
		
		
		
	}
    //4th method..... taking vehicle type as paramenter and doing view all customer operation
	@Override
	public List<Customer> viewAllCustomer(String vtype) {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();
	    int vehicleId = vehicleService.findByVehicleType(vtype);
		List<Booking> booking = bookingService.viewAllBookingByVehicle(vehicleId);
		logger.info("searched by vehicle type in viewAllCustomer method: "+booking);
		for(Booking b : booking) {
			customers.add(b.getCustomer());
		}
		
		return customers;
	}
    //5th method.... taking address as paramereter and finding all customers in that location
	@Override
	public List<Customer> viewAllCustomersByLocation(String location) {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findByAddress(location);
		logger.info("No of resulted customer in viewAllCustomerByLocation method: "+customers.size());
		if(customers != null) {
			return customers;
		}
		return null;
	}
    //6th mehtod... taking customer's id as parameter and finding that customer
	@Override
	public Customer viewCustomerById(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepository.findById(id);
		logger.info("searched by id in viewCustomer method: "+customer.get());
		return customer.get();
	}

	
	
	

}
