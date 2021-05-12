package com.cg.ovms.entities;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String emailId;
	private String address;
	public Customer() {
		
	}
	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String emailId,
			String address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", address=" + address + "]";
	}
	
}
