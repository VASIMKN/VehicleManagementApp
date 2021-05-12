package com.cg.ovms.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="PAYMENT")
public class Payment {
	@Id
	@Column(name="PAYMENT_ID")
	private int paymentId;
	@Column(name="PAYMENT_MODE")
	private String paymentMode;
	@Column(name="PAYMENT_DATE")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate paymentDate;
	//private Booking booking;
	@Column(name="PAYMENT_STATUS")
	private String paymentStatus;
	public Payment() {
		
	}
	public Payment(int paymentId, String paymentMode, LocalDate paymentDate,/* Booking booking,*/ String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
	//	this.booking = booking;
		this.paymentStatus = paymentStatus;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	/*public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}*/
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", paymentStatus=" + paymentStatus
				+ "]";
	}
	
}
