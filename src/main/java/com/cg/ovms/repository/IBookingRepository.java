package com.cg.ovms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.Vehicle;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

	@Query("SELECT b fROM Booking b WHERE b.customer= :customer")
	public List<Booking> viewAllBooking(@Param("customer") Customer customer);
	@Query("SELECT b FROM Booking b WHERE b.bookingDate= :bookingDate")
	public List<Booking> viewAllBookingByDate(@Param("bookingDate") LocalDate bookingDate);
	@Query("SELECT b FROM Booking b WHERE b.vehicle= :vehicle")
	public List<Booking> viewAllBookingByVehicle(@Param("vehicle") Vehicle vehicle);
}
