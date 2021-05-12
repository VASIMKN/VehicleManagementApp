package com.cg.ovms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Payment;
import com.cg.ovms.entities.Vehicle;

public interface IPaymentService {

	public Payment addPayment(Payment payment);
	public Payment cancelPayment(Payment p);
	public Payment viewPayment(Payment p);
	//public double calculateMonthlyRevenue(LocalDate d1,LocalDate d2);
	//public List<Booking> viewAllPayments(Vehicle vehicle);
	//public double calculateTotalPayment(Vehicle v);
}
