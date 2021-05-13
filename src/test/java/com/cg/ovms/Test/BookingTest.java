package com.cg.ovms.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.DateInput;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.ICustomerRepository;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.IBookingService;
import com.cg.ovms.service.IVehicleService;

@SpringBootTest
public class BookingTest {

	@MockBean
	IBookingRepository bookingRepository;
	@Autowired
	IBookingService bookingService;

	@MockBean
	IVehicleService IVehicleService;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	
	public Booking bookingData() {
		Booking booking = new Booking();
		Customer customer = new Customer();
		customer.setCustomerId(1);
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(1);
		vehicle.setVehicleNumber("12345");
		DateInput dinput = new DateInput();
		dinput.setDate("2021-05-10");
		DateInput dinput1 = new DateInput();
		dinput1.setDate("2021-05-15");	
		booking.setBookingId(4);///
		booking.setCustomer(customer);
		booking.setVehicle(vehicle);
		booking.setBookingDate(dinput.getDate());
		booking.setBookedTillDate(dinput1.getDate());
		booking.setBookingDescription("abcde");
		booking.setDistance(20);
		booking.setTotalCost(500);
		return booking;
	}
	public Booking bookingData2() {
		Booking booking = new Booking();
		Customer customer = new Customer();
		customer.setCustomerId(1);
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(1);
		vehicle.setVehicleNumber("12345");
		DateInput dinput = new DateInput();
		dinput.setDate("2021-05-10");
		DateInput dinput1 = new DateInput();
		dinput1.setDate("2021-05-15");	
		booking.setBookingId(5);///
		booking.setCustomer(customer);
		booking.setVehicle(vehicle);
		booking.setBookingDate(dinput.getDate());
		booking.setBookedTillDate(dinput1.getDate());
		booking.setBookingDescription("abcde");
		booking.setDistance(20);
		booking.setTotalCost(500);
		return booking;
	}
	
	
	@Test
	public void addBooking() {
		Booking booking = bookingData();
		when(bookingRepository.save(booking)).thenReturn(booking);
		assertEquals(booking,bookingService.addBooking(booking));
		
		
	}
	@Test
	public void cancelBooking() {
		
		Booking booking = bookingData();
		when(bookingRepository.findById(4)).thenReturn(Optional.of(booking));
		
		
		Booking b =bookingService.cancelBooking(4);// passing here booking id
		
		verify(bookingRepository,times(1)).delete(booking);
		
	}
	
	@Test
	public void updateBooking() {
		
		
		Booking value = bookingData();
		when(bookingRepository.findById(4)).thenReturn(Optional.of(value));
		Optional<Booking> booking = bookingRepository.findById(4);
		Booking booking1 = booking.get();
		
		
		if(booking.isPresent()) {
			booking1.setDistance(22);
			when(bookingRepository.save(booking1)).thenReturn(booking1);
			assertEquals(20,bookingService.updateBooking(booking.get()).getDistance());
			
		}
		
		
			
		
		
	}
	
	@Test
	public void viewBooking() {
		Booking booking = bookingData();
		when(bookingRepository.findById(4)).thenReturn(Optional.of(booking));
		assertEquals(booking, bookingService.viewBooking(4));
	}

	@Test
	public void viewAllBookingByVehicle() {
		Booking booking = bookingData();
		Booking booking1 = bookingData2();
		List<Booking> list = new ArrayList<Booking>();
		List<Booking> list1 = new ArrayList<Booking>();
		list.add(booking);
		list1.add(booking1);
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(1);
		when(IVehicleService.viewVehicle(1)).thenReturn(vehicle);
		when(bookingRepository.viewAllBookingByVehicle(IVehicleService.viewVehicle(1))).thenReturn(list);
		assertEquals(list, bookingService.viewAllBookingByVehicle(1));
		
	}
	@Test
	public void viewAllBookingByDate() {
		Booking booking = bookingData();
		List<Booking> list = new ArrayList<Booking>();
		list.add(booking);
		LocalDate ldate = booking.getBookingDate();
		when(bookingRepository.viewAllBookingByDate(ldate)).thenReturn(list);
		assertEquals(list, bookingService.viewAllBookingByDate(ldate));
	}
	
	
}
