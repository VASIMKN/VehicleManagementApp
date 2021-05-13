package com.cg.ovms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.Customer;
import com.cg.ovms.exception.DuplicateIdException;
import com.cg.ovms.exception.NotFoundException;
import com.cg.ovms.service.ICustomerService;


@RestController
@CrossOrigin
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	// 1st mehtod......(add)
	@PostMapping(path="/add",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		try {
			Customer cust = customerService.viewCustomerById(customer.getCustomerId());
		}
		catch(Exception e){
			customerService.addCustomer(customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		
		
		
		throw new DuplicateIdException("The customer is already present");
		
		
		
	}
	
	
	// 2nd method....(view)
	@GetMapping(path = "/view/{id}", produces = "application/json")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable("id")int id){
	//(@RequestBody Customer customer){
	//
		//Customer customer = cu
		try {
			Customer c = customerService.viewCustomerById(id);
			return new ResponseEntity<Customer>(c, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NotFoundException("No customer exists with this id");
		}
		
		
		
	}
	
	// 3rd method......(delete)
	@DeleteMapping(path="/delete/{id}", consumes="application/json", produces="application/json")
	public ResponseEntity<String> removeCustomer(@PathVariable("id") int id) {
		
		try {
			Customer cust = customerService.viewCustomerById(id);
			Customer customerResult = customerService.removeCustomer(id);
			return new ResponseEntity<String>("Customer data has been deleted successfully",HttpStatus.OK);
		}
		catch(Exception e){
			throw new NotFoundException("No customer exists with this id");
		}
		
		
		
		
		
	}
	
	// 4rd method......(update)
	@PostMapping(path="/update",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) {
		
		try {
			Customer cust = customerService.viewCustomerById(c.getCustomerId());
		}
		catch(Exception e){
			throw new NotFoundException("No customer exists");
		}
		Customer customerResult = customerService.updateCustomer(c);
		return new ResponseEntity<Customer>(customerResult,HttpStatus.OK); 
		
		
		
	}
	
	
	// 5th method......(find by address)
	@GetMapping(path = "/view/address/{address}", produces = "application/json")
	public ResponseEntity<List<Customer>> viewAllCustomersByLocation(@PathVariable("address")String address){
		List<Customer> customers = customerService.viewAllCustomersByLocation(address);
		
		if(customers.isEmpty()) {
			throw new NotFoundException("No customer exists with this address");
		}
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK); 
		
	}
	
	//6h method.....(find by vehicle type)
	@GetMapping(path="/view/byvehicle/{vtype}",  produces = "application/json")
	public ResponseEntity<List<Customer>> viewAllCustomer(@PathVariable("vtype") String vtype){
		try {
			List<Customer> result = customerService.viewAllCustomer(vtype);
			return new ResponseEntity<List<Customer>>(result,HttpStatus.OK); 
		}
		catch(Exception e) {
			throw new NotFoundException("No booking is there with this vehicleit ");
		}
			
			
			
	}
	
	
	
}
