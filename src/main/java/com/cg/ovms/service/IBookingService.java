package com.cg.ovms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.Vehicle;

@Service
public interface IBookingService {

	public Booking addBooking(Booking booking);

	public Booking cancelBooking(int id);

	public Booking updateBooking(Booking b);

	public Booking viewBooking(int id);

	
	public List<Booking> viewAllBooking(Customer customer);

	public List<Booking> viewAllBookingByDate(LocalDate bookingDate);

	public List<Booking> viewAllBookingByVehicle(int id);

}
