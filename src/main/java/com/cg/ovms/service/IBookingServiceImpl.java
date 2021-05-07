//package com.cg.ovms.service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.ovms.entities.Booking;
//import com.cg.ovms.entities.Customer;
//import com.cg.ovms.entities.Vehicle;
//import com.cg.ovms.repository.IBookingRepository;
//
//@Service
//public class IBookingServiceImpl implements IBookingService{
//
//	@Autowired
//	IBookingRepository bookingRepository;
//	
//	
//	@Override
//	@Transactional
//	public Booking addBooking(Booking booking) {
//		// TODO Auto-generated method stub
//		bookingRepository.save(booking);
//		return booking;
//	}
//
//	@Override
//	public Booking cancelBooking(Booking b) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Booking updateBooking(Booking b) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Booking viewBooking(Booking b) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Booking> viewAllBooking(Customer customer) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Booking> viewAllBookingByDate(LocalDate bookingDate) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Booking> viewAllBookingByVehicle(Vehicle vehicle) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//	
//}
