package com.cg.ovms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {


	@Id
	@Column(name="customer_id")
	private int customerId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="mobile_number")
	private String mobileNumber;
	@Column(name="email_id")
	private String emailId;
	@Column(name="address")
	private String address;
	
	public Customer() {
	
	}
	
	public Customer(int customerId,String firstName, String lastName, String mobileNumber, String emailId,
			String address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
	}
	

	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public void setCustomer(Customer c) {
		this.customerId = c.customerId;
		this.firstName = c.firstName;
		this.lastName = c.lastName;
		this.mobileNumber = c.mobileNumber;
		this.emailId = c.emailId;
		this.address = c.address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", address=" + address + "]";
	}
	
	
	
	
}
