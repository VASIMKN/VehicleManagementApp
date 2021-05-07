package com.cg.ovms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cg.ovms")
public class VehicleManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleManagementAppApplication.class, args);
	}

}
