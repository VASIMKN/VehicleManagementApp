package com.cg.ovms.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.exception.NotFoundException;
import com.cg.ovms.repository.IVehicleRepository;
import com.cg.ovms.service.IVehicleService;

@SpringBootTest
public class VehicleTest {

	@MockBean
	private IVehicleRepository vehicleRepository;

	@Autowired
	private IVehicleService vehicleService;

	@Test
	public void testAddVehicle() {

		Driver driver = new Driver(1, "abc", "xyz", "9876543210", "abc@cg.com", "Mumbai", 5000, "abcxyz1");
		Vehicle vehicle = new Vehicle(101, driver, "MH2020", "Car", "AC", "ABCD", "MUM", "Six", 800, 15000);
		Driver driver1 = new Driver(2, "navin", "anand", "9218124651", "navin@cg.com", "Delhi", 3000, "navinanand");
		Vehicle vehicle1 = new Vehicle(102, driver1, "UP2020", "Bus", "NON-AC", "NON-AC Bus", "Lucknow", "50", 1000, 25000);
		when(vehicleRepository.save(vehicle)).thenReturn(vehicle);
		assertEquals(vehicle, vehicleService.addVehicle(vehicle));

	}

	@Test
	public void testFindVehicle() {
		Driver driver = new Driver(1, "abc", "xyz", "9876543210", "abc@cg.com", "Mumbai", 5000, "abcxyz1");
		Vehicle vehicle = new Vehicle(101, driver, "MH2020", "Car", "AC", "ABCD", "MUM", "Six", 800, 15000);
		vehicleService.cancelVehicle(vehicle.getVehicleId());
		verify(vehicleRepository, times(1)).findById(101);
	}

	@Test
	void testNotFoundException() throws NotFoundException {
		assertThrows(NotFoundException.class, () -> {
			vehicleService.viewVehicle(10);
		});
	}
	
}
