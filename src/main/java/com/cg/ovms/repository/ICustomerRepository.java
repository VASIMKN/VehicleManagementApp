package com.cg.ovms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ovms.entities.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{


	@Query("SELECT c FROM Customer c WHERE c.address= :address")
	public List<Customer> findByAddress(@Param("address") String address);

	
}
