package com.cg.ovms.service;

import java.util.List;

import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;

public interface IVehicleService {

	public Vehicle addVehicle(Vehicle v);
	public Vehicle updateVehicle(Vehicle v);
	public Vehicle cancelVehicle(int id);
	public Vehicle viewVehicle(int id);
	public List<Vehicle> viewAllVehicle(Driver driver) ;
	public List<Vehicle> viewAllVehicles();
	public int findByVehicleType(String vtype);
}
