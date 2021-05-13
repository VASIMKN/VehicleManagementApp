package com.cg.ovms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="driver")
public class Driver {

	@Id
	@Column(name="driver_id")
	private int driverId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="contact_number")
	private String contactNumber;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="charge_per")
	private double chargesPerDay;
	@Column(name="license_no")
	private String licenseNo;
	
	public Driver() {
		
	}
	
	
	public Driver(int driverId, String firstName, String lastName, String contactNumber, String email, String address,
			double chargesPerDay, String licenseNo) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.chargesPerDay = chargesPerDay;
		this.licenseNo = licenseNo;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getChargesPerDay() {
		return chargesPerDay;
	}


	public void setChargesPerDay(double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}


	public String getLicenseNo() {
		return licenseNo;
	}


	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}


	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", address=" + address + ", chargesPerDay="
				+ chargesPerDay + ", licenseNo=" + licenseNo + "]";
	}
	
	
	
	
}
