package com.cg.ovms.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.repository.ICustomerRepository;
import com.cg.ovms.service.ICustomerService;

@SpringBootTest

public class CustomerTest {

	@Autowired
	ICustomerService customerService;
	@MockBean
	ICustomerRepository customerRepository;
	
	
	public Customer customerData() {
		Customer customer = new Customer();
		customer.setCustomerId(7);
		customer.setFirstName("sourav");
		customer.setLastName("Dalal");
		customer.setAddress("kolkata");
		customer.setEmailId("r@g.com");
		customer.setMobileNumber("815");
		return customer;
	}
	
	
	//1st.... test case for add customer operation
	@Test
	public void addCustomer() {
		Customer customer = customerData();
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer,customerService.addCustomer(customer));
		
		
	}
	//2nd..... test case for remove customer operation
	@Test
	public void removeCustomer() {
		Customer customer = customerData();
		when(customerRepository.findById(7)).thenReturn(Optional.of(customer));
		 Customer c =customerService.removeCustomer(7);
		 verify(customerRepository,times(1)).delete(customer);
		//Customer c = new Customer();
		//c.setCustomerId(2);
		//Customer customer = customerRepository.findById(6).get();
		
		//Customer customer1 = customerService.removeCustomer(6);
		//String firstName = customerRepository.findById(5).get().getFirstName();
		//assertThat(firstName.equals(null));
		//assertThrows(Exception.class, ()->{
		//	customerRepository.findById(6).get();
        //});
       // passing here booking id
		
		
		//assertThrows(null, null)
		
		//when(customerRepository.findById(2)).thenReturn(Optional.of(c));
		//Assertions.assertDoesNotThrow(()-> customerService.removeCustomer(4));
	}
	//3rd.... test case for update customer operation
	@Test
	public void updateCustomer() {
//		Optional<Customer> customer = customerRepository.findById(1);
//		if(customer.isPresent()) {
//			customer.get().setFirstName("sourav");
//			customerService.addCustomer(customer.get());
//			
//		}
//		Customer updatedCust = customerService.viewCustomerById(1);
//				//customerRepository.findById(1);
//		if(updatedCust != null) {
//			assertThat(updatedCust.getFirstName().equals("sourav"));
//		}
		
		Customer value = customerData();
		when(customerRepository.findById(7)).thenReturn(Optional.of(value));
		Optional<Customer> customer = customerRepository.findById(7);
		Customer customer1 = customer.get();
		//System.out.println(booking);
		//Optional<Booking> booking1 = booking;
		if(customer.isPresent()) {
			customer1.setMobileNumber("81588");
			when(customerRepository.save(customer1)).thenReturn(customer1);
			customerService.updateCustomer(customer.get());
			assertEquals("81588",customerRepository.findById(7).get().getMobileNumber());
			//customerRepository.save(customer.get());
		}
		//Optional<Customer> updatedCustomer = customerRepository.findById(7);
		
			//assertEquals("81588",customerService.updateCustomer(customer.get()).getMobileNumber());
		
	}
	//4th .... test case for view customer operation
	@Test
	public void viewCustomerById() {
//		Customer customer = customerService.viewCustomerById(1);
//		Customer customer1 = customerRepository.findById(1).get();
//		
//			assertEquals(customer.getCustomerId(),customer1.getCustomerId());
		
			Customer customer = customerData();
			when(customerRepository.findById(7)).thenReturn(Optional.of(customer));
			assertEquals(customer, customerService.viewCustomerById(7));
	}
	
	
}
