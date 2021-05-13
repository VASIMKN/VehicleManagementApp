package com.cg.ovms.service;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.VehicleManagementAppApplication;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.NotFoundException;
import com.cg.ovms.repository.IDriverRepository;
import com.cg.ovms.repository.IVehicleRepository;

//VehicleServiceImpl class provides definition to the methods declared in IVehicleService interface.
@Service
public class IVehicleServiceImpl implements IVehicleService {

	private static final Logger log=LoggerFactory.getLogger(IVehicleServiceImpl.class);
	
	@Autowired
	IVehicleRepository vehicleRepository;

	@Autowired
	IDriverRepository driverRepository;

	@Override
	@Transactional
	public Vehicle addVehicle(Vehicle v) {
		Driver d = driverRepository.findById(v.getDriver().getDriverId());
		if (d != null) {
			log.info("Driver Present");
			v.setDriver(d);
		} else {
			return null;
		}
		return vehicleRepository.save(v);
	}

	@Override
	@Transactional
	public Vehicle updateVehicle(Vehicle v) {
		Vehicle vehicle = viewVehicle(v.getVehicleId());
		if (vehicle == null) {
			return null;
		}
		vehicleRepository.save(v);
		return vehicle;
	}

	@Override
	public Vehicle cancelVehicle(int id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		Vehicle v = null;
		if (vehicle.isPresent()) {
			v = vehicle.get();
			vehicleRepository.delete(v);
		} else {
			return null;
		}
		return v;
	}

	@Override
	public Vehicle viewVehicle(int id){
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		
		return vehicle.get();
	}

	@Override
	public List<Vehicle> viewAllVehicle(Driver driver) {
		List<Vehicle> vehicles = vehicleRepository.findVehicleByDriver(driver);
		return vehicles;
	}

	@Override
	public List<Vehicle> viewAllVehicles() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicles;
	}

	@Override
	public int findByVehicleType(String vtype) {
		// TODO Auto-generated method stub
		int id = vehicleRepository.findByVehicleType(vtype);
		return id;
	}

	
}
