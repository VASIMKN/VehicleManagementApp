package com.cg.ovms.service;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Payment;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IPaymentRepository;

@Service
public class IPaymentServiceImpl implements IPaymentService {

	@Autowired
	IPaymentRepository paymentRepository;

	@Autowired
	IBookingRepository bookingRepository;

	@Override
	@Transactional
	public Payment addPayment(Payment p) {
		Optional<Booking> booking = bookingRepository.findById(p.getBooking().getBookingId());
		if (booking.isPresent()) {
			p.setBooking(booking.get());
		} else {
			return null;
		}
		paymentRepository.save(p);
		return p;
	}

	@Override
	public Payment cancelPayment(int id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		if (payment.isEmpty()) {
			return null;
		}
		Payment p = payment.get();
		paymentRepository.delete(p);
		return p;
	}

	@Override
	public Payment viewPayment(Booking b) {
		return paymentRepository.findPaymentsByBooking(b);
	}

	@Override
	public List<Payment> viewAllPayment(Vehicle vehicle) {
		List<Payment> payments = paymentRepository.findPaymentByVehicle(vehicle);
		return payments;
	}

	@Override
	public double calculateMonthlyRevenue(LocalDate d1, LocalDate d2) {
		return paymentRepository.findTotalPaymentByDates(d1, d2);

	}

	@Override
	public double calculateTotalPayment(Vehicle vehicle) {
		return paymentRepository.findTotalPaymentByVehicle(vehicle);
	}

	@Override
	public List<Payment> viewPayments() {
		List<Payment> payments = paymentRepository.findAll();
		return payments;
	}

}
