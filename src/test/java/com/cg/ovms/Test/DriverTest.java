package com.cg.ovms.Test;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.repository.IDriverRepository;
import com.cg.ovms.service.IDriverService;

@SpringBootTest
public class DriverTest {

	@MockBean
	IDriverRepository driverRepository;
	
	@Autowired
	IDriverService driverService;
	
	@Test
	public void testAddDriver() {
		Driver driver = new Driver(1, "alpha", "rider", "6265626515", "alpha@cg.com", "MUM", 500, "alprider");
		
		when(driverRepository.save(driver)).thenReturn(driver);
		assertEquals(driver, driverService.addDriver(driver));
	}
	
	
	@Test
	public void testFindById() {
		Driver driver = new Driver(4, "vasim", "khan", "1151515155", "vasim@cg.com", "Thane", 5000, "ghhggh1");
		driverService.viewDriver(driver.getDriverId());
		verify(driverRepository, times(1)).findById(6);
	}
	
	
	
}
