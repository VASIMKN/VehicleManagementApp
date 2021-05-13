package com.cg.ovms.service;

import java.util.List;

import com.cg.ovms.entities.Driver;

public interface IDriverService {

	public Driver addDriver(Driver d);
	public Driver updateDriver(Driver d);
	public Driver removeDriver(int id);
	public Driver viewDriver(int id);
	public List<Driver> viewAllDrivers();
}
