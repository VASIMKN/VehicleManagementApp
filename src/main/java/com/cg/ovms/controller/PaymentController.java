package com.cg.ovms.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.cg.ovms.entities.Payment;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.NotFoundException;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IPaymentRepository;
import com.cg.ovms.service.IPaymentService;

@RestController
@CrossOrigin
@RequestMapping("/Payment")
public class PaymentController {

	@Autowired
	IPaymentService paymentService;

	//method for adding payment
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment p) throws NotFoundException {
		Payment payment = paymentService.addPayment(p);
		if (payment != null) {
			return new ResponseEntity<>(payment, HttpStatus.CREATED);
		}
		throw new NotFoundException("Booking with Id " + p.getBooking().getBookingId() + " not found");
	}

	//method for delete payment by its id
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Vehicle> deletePayment(@PathVariable("id") int id) throws NotFoundException {
		Payment p = paymentService.cancelPayment(id);
		if (p != null) {
			return new ResponseEntity("Payment successfully Deleted", HttpStatus.OK);
		}
		throw new NotFoundException("Payment with Id " + id + " not found");
	}

	//method for view all payments
	@GetMapping(path = "/viewAllPayments", produces = "application/json")
	public ResponseEntity<List<Payment>> viewPayments() throws NotFoundException {
		List<Payment> payments = paymentService.viewPayments();
		if (payments.isEmpty()) {
			throw new NotFoundException("No payments found");
		}
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}

	//method for view payments by booking
	@GetMapping(path = "/viewPaymentsByBooking", produces = "application/json")
	public ResponseEntity<Payment> viewPaymentByBooking(@RequestBody Booking booking) {
		Payment payments = paymentService.viewPayment(booking);
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}

	//method for viewing payments by vehicle
	@GetMapping(path = "/paymentsByVehicle", produces = "application/json")
	public ResponseEntity<List<Payment>> findPaymentsByVehicle(@RequestBody Vehicle vehicle) throws NotFoundException {
		List<Payment> payments = paymentService.viewAllPayment(vehicle);
		if (payments.isEmpty()) {
			throw new NotFoundException("No payments found");
		}
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}

	//method for calculate total payments by vehicle
	@GetMapping(path = "/totalPaymentByVehicle")
	public ResponseEntity<Double> calculateTotalPaymentByVehicle(@RequestBody Vehicle vehicle) {
		Double revenue = paymentService.calculateTotalPayment(vehicle);
		return new ResponseEntity<>(revenue, HttpStatus.OK);
	}

	//method for calculate monthly revenue of payments
	@GetMapping(path = "/calculateMonthlyRevenue/{date1}/{date2}")
	public ResponseEntity<Double> calculateTMonthlyRevenue(
			@PathVariable("date1") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date1,
			@PathVariable("date2") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date2) {
		Double revenue = paymentService.calculateMonthlyRevenue(date1, date2);
		return new ResponseEntity<>(revenue, HttpStatus.OK);
	}
}
