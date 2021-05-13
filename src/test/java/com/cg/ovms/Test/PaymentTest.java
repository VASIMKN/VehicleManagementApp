package com.cg.ovms.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.convert.JodaTimeConverters.DateTimeToDateConverter;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Payment;
import com.cg.ovms.repository.IPaymentRepository;
import com.cg.ovms.service.IPaymentService;

@SpringBootTest
public class PaymentTest {

	@Autowired
	IPaymentService paymentService;

	@MockBean
	IPaymentRepository paymentRepository;

	@Test
	public void testAddPayment() {
		Booking booking = new Booking();
		booking.setBookingId(5);
		Payment payment = new Payment(2, "Cash", null, booking, "Done");
		when(paymentRepository.save(payment)).thenReturn(payment);
		assertEquals(payment, paymentService.addPayment(payment));
	}
	
	@Test
	public void testFindById() {
		Booking booking = new Booking();
		booking.setBookingId(5);
		Payment payment = new Payment(2, "Cash", null, booking, "Done");
		paymentService.cancelPayment(payment.getPaymentId());
		verify(paymentRepository,times(1)).findById(2);
	}

}
