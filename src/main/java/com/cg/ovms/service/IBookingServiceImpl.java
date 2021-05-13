package com.cg.ovms.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.ICustomerRepository;
import com.cg.ovms.repository.IVehicleRepository;

@Service
public class IBookingServiceImpl implements IBookingService{
	private static final Logger logger = LoggerFactory.getLogger(ICustomerServiceImpl.class);

	@Autowired
	IBookingRepository bookingRepository;
	@Autowired
	ICustomerService customerService;
	@Autowired
	IVehicleService vehicleService;
	
	//1st method..... taking booking as parameter and doing add booking operation
	@Override
	@Transactional
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		//Driver driver = driverService.viewDriver(vehicle.getDriver().getDriverId());
		//vehicle.setDriver(driver);
		int vid = booking.getVehicle().getVehicleId();
		Vehicle vehicle = vehicleService.viewVehicle(vid);
		booking.setVehicle(vehicle);
		int cid = booking.getCustomer().getCustomerId();
		Customer customer = customerService.viewCustomerById(cid);
		booking.setCustomer(customer);
		Booking result = bookingRepository.save(booking);
		logger.info("result of addBooking method : "+result);
		return result;
	}
	//2nd method... taking booking id as parameter as doing remove operation
	@Override
	public Booking cancelBooking(int id) {
		// TODO Auto-generated method stub
		Booking b = bookingRepository.findById(id).get();
		b.setVehicle(null);
		b.setCustomer(null);
		bookingRepository.delete(b);
		logger.info("Inside cancelBooking method and cancelation operation has done");
		return b;
	}
	//3rd method.....taking booking as parameter and doing update operation
	@Override
	public Booking updateBooking(Booking b) {
		// TODO Auto-generated method stub
		int vid = b.getVehicle().getVehicleId();
		Vehicle vehicle = vehicleService.viewVehicle(vid);
		b.setVehicle(vehicle);
		int cid = b.getCustomer().getCustomerId();
		Customer customer = customerService.viewCustomerById(cid);
		b.setCustomer(customer);
		Booking booking =bookingRepository.save(b);
		logger.info("resulted Booking in updateBooking method: "+ booking);
		return booking;
	}
	//4th mehtod... taking booking's id as parameter and finding that booking details
	@Override
	public Booking viewBooking(int id) {
		// TODO Auto-generated method stub
		Booking booking = bookingRepository.findById(id).get();
		logger.info("searched by id in viewBooking method: "+booking);
		return booking;
	}
	//5th mehtod... taking customer as parameter and finding all booking what that customer has done
	@Override
	public List<Booking> viewAllBooking(Customer customer) {
		// TODO Auto-generated method stub
		List<Booking> bookings = bookingRepository.viewAllBooking(customer);
		logger.info("inside viewAllBooking mehtod by customer mehtod");
		return bookings;
	}
    //6th.... taking bookingDate as a parameter and finding all bookings list on that date
	@Override
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate) {
		// TODO Auto-generated method stub
		List<Booking> bookings = bookingRepository.viewAllBookingByDate(bookingDate);
		logger.info("searched by booking date in viewAllBookingByDate method: "+bookings);
		return bookings;
	}
    // 7th.... taking vehicle id as parameter and finding all booking of that vehicle
	@Override
	public List<Booking> viewAllBookingByVehicle(int id) {
		// TODO Auto-generated method stub
		Vehicle vehicle = vehicleService.viewVehicle(id);
		List<Booking> bookings = bookingRepository.viewAllBookingByVehicle(vehicle);
		logger.info("searched by vehicle id in viewAllBookingByDate method: "+bookings);
		return bookings;
	}

	
	
}
