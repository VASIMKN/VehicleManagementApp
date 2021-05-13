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

import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.NotFoundException;
import com.cg.ovms.service.IVehicleService;

@RestController
@CrossOrigin
@RequestMapping("/Vehicle")
public class VehicleController {

	@Autowired
	private IVehicleService vehicleService;

	// Method for adding Vehicle
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v) throws NotFoundException {
		Vehicle vehicle = vehicleService.addVehicle(v);
		if (vehicle != null) {
			return new ResponseEntity(vehicle, HttpStatus.OK);
		}
		throw new NotFoundException("Driver with Id " + v.getDriver().getDriverId() + " not found");
	}

	// Method for viewing Vehicle by vehicleId
	@GetMapping(path = "/view/{id}", produces = "application/json")
	public ResponseEntity<Vehicle> viewVehicle(@PathVariable("id") int id) throws NotFoundException {
		Vehicle vehicle = vehicleService.viewVehicle(id);
		if (vehicle != null) {
			return new ResponseEntity(vehicle, HttpStatus.OK);
		}
		throw new NotFoundException("Vehicle with Id " + id + " not found");
	}

	// Method for update details for vehicle
	@PutMapping(path = "/update", consumes = "application/json")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle v) throws NotFoundException {
		Vehicle vehicle = vehicleService.updateVehicle(v);
		if (vehicle != null) {
			return new ResponseEntity("Vehicle with id " + v.getVehicleId() + " is successfully updated",
					HttpStatus.OK);
		}
		throw new NotFoundException("Vehicle with Id " + v.getVehicleId() + " not found");
	}

	// Method for delete vehicle by vehicleId
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") int id) throws NotFoundException {
		Vehicle v = vehicleService.cancelVehicle(id);
		if (v != null) {
			return new ResponseEntity("Vehicle with id " + id + " is successfully Deleted", HttpStatus.OK);
		}
		throw new NotFoundException("Vehicle with Id " + id + " not found");
	}

	// Method for viewing all Vehicle by driver
	@GetMapping(path = "/vehicles", produces = "application/json")
	public ResponseEntity<List<Vehicle>> viewAllVehicle(@RequestBody Driver driver) throws NotFoundException {
		List<Vehicle> vehicles = vehicleService.viewAllVehicle(driver);
		if (vehicles.isEmpty()) {
			throw new NotFoundException("Vehicle Not Found");
		}
		return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}

	// Method for viewing all Bookings
	@GetMapping(path = "/viewAllVehicles", produces = "application/json")
	public ResponseEntity<List<Vehicle>> viewAllBooking() throws NotFoundException {
		List<Vehicle> vehicles = vehicleService.viewAllVehicles();
		if (vehicles.isEmpty()) {
			throw new NotFoundException("No Booking Found");
		}
		return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}

}