package com.cg.ovms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.Customer;
import com.cg.ovms.entities.Driver;
import com.cg.ovms.exception.AlreadyExistsException;
import com.cg.ovms.exception.NotFoundException;
import com.cg.ovms.service.IDriverService;

@RestController
@CrossOrigin
@RequestMapping("/Driver")
public class DriverController {

	@Autowired
	private IDriverService driverService;

	// Method for adding Driver
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Driver> addingDriver(@RequestBody Driver driver) throws AlreadyExistsException {
		Driver d = driverService.addDriver(driver);
		if (d == null) {
			throw new AlreadyExistsException(
					"Driver with " + driver.getFirstName() + " " + driver.getLastName() + " already Exists");
		}
		return new ResponseEntity<Driver>(driver, HttpStatus.OK);
	}

	// Method for delete Driver by Id
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Driver> deleteDriverById(@PathVariable("id") int id) throws NotFoundException {
		Driver driver = driverService.removeDriver(id);
		if (driver == null) {
			throw new NotFoundException("Driver with Id " + id + " not found");
		}
		return new ResponseEntity("Driver with id " + id + " is Successfully Deleted", HttpStatus.OK);
	}

	// Method for updating driver detail
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> updateDriver(@RequestBody Driver driver) throws NotFoundException {
		Driver result = driverService.updateDriver(driver);
		if (result != null) {
			return new ResponseEntity("Driver with id " + driver.getDriverId() + " is successfully Updtaed",
					HttpStatus.OK);
		}
		throw new NotFoundException("Driver with Id " + driver.getDriverId() + " not found");
	}

	// Method for view Driver detail by driverId
	@GetMapping(path = "/view/{id}", produces = "application/json")
	public ResponseEntity<Driver> viewCustomerById(@PathVariable("id") int id) throws NotFoundException {
		Driver d = driverService.viewDriver(id);
		if (d == null) {
			throw new NotFoundException("Driver with Id " + id + " not found");
		}
		return new ResponseEntity<Driver>(d, HttpStatus.OK);
	}

	// Method for viewing all drivers details
	@GetMapping(path = "/viewAllDriver", produces = "application/json")
	public ResponseEntity<List<Driver>> viewDrivers() throws NotFoundException {
		List<Driver> driver = driverService.viewAllDrivers();
		if (driver == null) {
			throw new NotFoundException("No Drivers Found");
		}
		return new ResponseEntity<>(driver, HttpStatus.OK);
	}

}
