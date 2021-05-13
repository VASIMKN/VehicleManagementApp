package com.cg.ovms.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.DateInput;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.DuplicateIdException;
import com.cg.ovms.exception.NotFoundException;
import com.cg.ovms.service.IBookingService;
import com.cg.ovms.service.ICustomerService;
import com.cg.ovms.service.IVehicleService;

@RestController
@CrossOrigin
@RequestMapping("/Booking")
public class BookingController {

	@Autowired
	IBookingService bookingService;
	@Autowired
	ICustomerService customerService;
	@Autowired
	IVehicleService vehicleService;
	//1st method..... add
	@PostMapping(path="/add",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking){
		Booking b;
		try {
			 b = bookingService.viewBooking(booking.getBookingId());
			
		}
		catch(Exception e){
			try {
				customerService.viewCustomerById(booking.getCustomer().getCustomerId());
				try {
					vehicleService.viewVehicle(booking.getVehicle().getVehicleId());
				}
				catch(Exception e1) {
					throw new NotFoundException("no vehicle exists with this id "+booking.getVehicle().getVehicleId());
				}
			}
			catch(NotFoundException e1) {
				throw new NotFoundException(e1.getMessage());
			}
			catch(Exception e1) {
				throw new NotFoundException("no customer exists with this id "+booking.getCustomer().getCustomerId());
			}
			
			Booking bookingResult = bookingService.addBooking(booking);
			return new ResponseEntity<Booking>(bookingResult, HttpStatus.OK);
		}
		
		throw new DuplicateIdException("The booking is already done with this id");
		
	}
	//2nd mehtod .... cancel
	@DeleteMapping(path="/cancel/{id}", produces = "application/json" )
	public ResponseEntity<String> cancelBooking(@PathVariable("id") int id){
		try {
			Booking b = bookingService.viewBooking(id);
			Booking bookingResult = bookingService.cancelBooking(id);
			return new ResponseEntity<String>("cancelation done", HttpStatus.OK);
		}
		catch(Exception e) {
			throw new NotFoundException("There has no booking with this id");
		}
		
		
	}
	//3rd method.... update
	@PostMapping(path="/update",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
		
		try {
			Booking b = bookingService.viewBooking(booking.getBookingId());
			
			try {
				customerService.viewCustomerById(booking.getCustomer().getCustomerId());
				
			}
			
			catch(Exception e1) {
				throw new NotFoundException("no customer exists with this id "+booking.getCustomer().getCustomerId());
			}
			try {
				vehicleService.viewVehicle(booking.getVehicle().getVehicleId());
			}
			catch(Exception e1) {
				throw new NotFoundException("no vehicle exists with this id "+booking.getVehicle().getVehicleId());
			}
			
			
			Booking bookingResult = bookingService.updateBooking(booking);
			
			
			return new ResponseEntity<Booking>(bookingResult, HttpStatus.OK);
		}
		catch(NotFoundException e) {
			throw new NotFoundException(e.getMessage());
		}
		catch(  Exception e){
			throw new NotFoundException("No Booking is there with this id");
		}
		
		
		
		
		
		
	}
	//4th method..... view by booking id
	@GetMapping(path="/view/{id}", produces = "application/json")
	public ResponseEntity<Booking> viewBooking(@PathVariable("id") int id){
		
		try {
			Booking bookingResult = bookingService.viewBooking(id);
			return new ResponseEntity<Booking>(bookingResult, HttpStatus.OK); 
		}
		catch(Exception e) {
			throw new NotFoundException("No Booking exists with this booking id");
		}
		
		
	}
	//5th method.... view by customer
	@GetMapping(path="view/bycustomer",consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Booking>> viewAllBookingByCustomer(@RequestBody Customer customer){
		
			List<Booking> bookings = bookingService.viewAllBooking(customer);
			if(bookings.isEmpty()) {
				throw new NotFoundException("no booking exists with this customer");
			}
			return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK); 
			
		
		
		
	}
	//6th method... view by booking date
	@GetMapping(path="view/bydate", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Booking>> viewAllBookingByDate(@RequestBody Booking booking){
		List<Booking> bookings = bookingService.viewAllBookingByDate(booking.getBookingDate());
		if(bookings.isEmpty()) {
			throw new NotFoundException("no booking exists with this date");
		}
		
			
			return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK); 
		
				
	}
	
	// 7th method.... view by vehicle id
	@GetMapping(path="view/byvehicle/{id}", produces = "application/json")
	public ResponseEntity<List<Booking>> viewAllBookingByVehicle(@PathVariable("id") int id){
		List<Booking> bookings;
		try {
			 bookings = bookingService.viewAllBookingByVehicle(id);
		}
		catch(Exception e) {
			throw new NotFoundException("no booking exists with this vehicle");
		}
		
				
			return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK); 
		
		
		
	}
}
