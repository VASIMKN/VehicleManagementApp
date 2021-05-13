package com.cg.ovms.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Booking")
public class Booking {

	@Id
	@Column(name="booking_id")
	private int bookingId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="customer_id")
	private Customer customer;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="vehicle_id")
	private Vehicle vehicle;
	
	@Column(name="booking_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingDate;
	
	@Column(name="booked_till")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookedTillDate;
	
	@Column(name="booking_description")
	private String bookingDescription;
	
	@Column(name="total_cost")
	private double totalCost;
	
	@Column(name="distance")
	private double distance;
	
	
	public Booking() {
		
	}
	
	
	public Booking(int bookingId, Customer customer, Vehicle vehicle, LocalDate bookingDate, LocalDate bookedTillDate,
			String bookingDescription, double totalCost, double distance) {
		super();
		this.bookingId = bookingId;
		this.customer = customer;
		this.vehicle = vehicle;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.totalCost = totalCost;
		this.distance = distance;
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public LocalDate getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}


	public LocalDate getBookedTillDate() {
		return bookedTillDate;
	}


	public void setBookedTillDate(LocalDate bookedTillDate) {
		this.bookedTillDate = bookedTillDate;
	}


	public String getBookingDescription() {
		return bookingDescription;
	}


	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customer=" + customer + ", vehicle=" + vehicle + ", bookingDate="
				+ bookingDate + ", bookedTillDate=" + bookedTillDate + ", bookingDescription=" + bookingDescription
				+ ", totalCost=" + totalCost + ", distance=" + distance + "]";
	}
	
	
	
	
}
