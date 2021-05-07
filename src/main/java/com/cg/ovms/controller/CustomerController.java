package com.cg.ovms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	

	
}
