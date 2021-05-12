package com.cg.ovms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Payment;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.repository.IPaymentRepository;
@Service
public class IPaymentServiceImpl implements IPaymentService {
	@Autowired
	public IPaymentRepository paymentRepository;
	@Override
	@Transactional
	public Payment addPayment(Payment payment) {
		// TODO Auto-generated method stub
		paymentRepository.saveAndFlush(payment);
		return payment;
	}
	@Override
	@Transactional
	public Payment viewPayment(Payment p) {
		// TODO Auto-generated method stub
		paymentRepository.findById(p.getPaymentId());
		return p;
	}
	@Override
	@Transactional
	public Payment cancelPayment(Payment p) {
		// TODO Auto-generated method stub
		paymentRepository.delete(p);
		return p;
	}
	/*@Override
	public double calculateMonthlyRevenue(LocalDate d1, LocalDate d2) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	/*@Override
	public List<Booking> viewAllPayments(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public double calculateTotalPayment(Vehicle v) {
		// TODO Auto-generated method stub
		return 0;
	}*/

}
