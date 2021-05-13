package com.cg.ovms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ovms.entities.Driver;
import com.cg.ovms.entities.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {
 
    public List<Vehicle> findVehicleByDriver(Driver driver);
	
	public Vehicle findVehicleByVehicleNumber(String number);
	@Query("SELECT v.vehicleId FROM Vehicle v WHERE v.type= :vtype")
	public int findByVehicleType(@Param("vtype") String vtype);
}
