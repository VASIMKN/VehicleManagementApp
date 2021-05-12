package com.cg.ovms.entities;

public class Vehicle {
	private  int vehicleId;
	private Driver driver;
	private String vehicleNumber;
	private String type;//car//bus
	private String category ; //ac or nonac
	private String description;
	private String location;
	private String capacity;
	private double chargesPerKM;
	private double fixedCharges;
	public Vehicle() {
		
	}
	public Vehicle(int vehicleId, Driver driver, String vehicleNumber, String type, String category, String description,
			String location, String capacity, double chargesPerKM, double fixedCharges) {
		super();
		this.vehicleId = vehicleId;
		this.driver = driver;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", driver=" + driver + ", vehicleNumber=" + vehicleNumber + ", type="
				+ type + ", category=" + category + ", description=" + description + ", location=" + location
				+ ", capacity=" + capacity + ", chargesPerKM=" + chargesPerKM + ", fixedCharges=" + fixedCharges + "]";
	}
	
}
