package com.cg.ovms.service;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Driver;
import com.cg.ovms.repository.IDriverRepository;

//DriverServiceImpl class provides definition to the methods declared in IDriverService interface.
@Service
public class IDriverServiceImpl implements IDriverService {

	@Autowired
	IDriverRepository driverRepository;

	@Override
	@Transactional
	public Driver addDriver(Driver driver) {
		Driver d = driverRepository.findByFirstNameAndLastName(driver.getFirstName(), driver.getLastName());
		if (d != null) {
			return null;
		}
		driverRepository.save(driver);
		return driver;
	}

	@Override
	@Transactional
	public Driver updateDriver(Driver d) {
		Driver driver = viewDriver(d.getDriverId());
		if (driver == null) {
			return null;
		}
		driverRepository.save(d);
		return d;

	}

	@Override
	public Driver removeDriver(int id) {
		Driver driver = driverRepository.findById(id);
		if (driver==null) {
			return null;
		}
		driverRepository.delete(driver);
		return driver;
	}

	@Override
	public Driver viewDriver(int id) {
		Driver driver = driverRepository.findById(id);
		if (driver==null) {
			return null;
		}
		return driver;
	}

	@Override
	public List<Driver> viewAllDrivers() {
		List<Driver> drivers = driverRepository.findAll();
		return drivers;
	}

}
