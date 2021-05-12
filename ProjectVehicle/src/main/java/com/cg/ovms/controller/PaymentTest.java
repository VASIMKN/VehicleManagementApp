package com.cg.ovms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.Payment;
import com.cg.ovms.service.IPaymentService;

@RestController
@RequestMapping("paymentdetails")
public class PaymentTest {
@Autowired
public IPaymentService paymentService;
@PostMapping(consumes="application/json", produces="application/json")
public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
	Payment result=paymentService.addPayment(payment);
	if(result!=null) {
		return new ResponseEntity<Payment>(result,HttpStatus.OK);
	}
	return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
}
@DeleteMapping(path="delete",consumes="application/json", produces="application/json")
public ResponseEntity<Payment> deletePayment(@RequestBody Payment payment){
	Payment result=paymentService.cancelPayment(payment);
	if(result!=null) {
		return new ResponseEntity<Payment>(result,HttpStatus.OK);
	}
	return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
}
@GetMapping(path="{paymentId}")
public ResponseEntity<Payment> viewPayment(@PathVariable ("paymentId") Payment payment){
	Payment result=paymentService.viewPayment(payment);
	if(result!=null) {
		return new ResponseEntity<Payment>(result,HttpStatus.OK);
	}
	return new ResponseEntity<Payment>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}
