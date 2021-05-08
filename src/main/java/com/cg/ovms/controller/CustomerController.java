package com.cg.ovms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.Customer;
import com.cg.ovms.service.ICustomerService;


@RestController
@CrossOrigin
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping(path="/addcustomer",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	
	@GetMapping(path = "/viewcustomer", produces = "application/json")
	public ResponseEntity<Customer> viewCustomer(@RequestBody Customer customer){
		
		Customer c = customerService.viewCustomer(customer);
		if (c == null) {
			return new ResponseEntity("Sorry! Invalid Customer ID", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/deletecustomer", consumes="application/json", produces="application/json")
	public ResponseEntity<Customer> removeCustomer(@RequestBody Customer customer) {
		Customer customerResult = customerService.removeCustomer(customer);
		if(customerResult!=null) {
			return new ResponseEntity<Customer>(customerResult,HttpStatus.OK); 
		}
		return new ResponseEntity<Customer>(customerResult,HttpStatus.NOT_FOUND);
	}
	
	
}
