package com.cg.ovms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ovms.entities.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

//	public Customer addCustomer(Customer customer);
//	public Customer removeCustomer(Customer customer);
//	public Customer viewCustomer(Customer c);
//	public Customer updateCustomer(Customer c);
//	public List<Customer> viewAllCustomer(String vtype);
//	public List<Customer> viewAllCustomersByLocation(String location);
	//@Query("SELECT c FROM Customer c WHERE c.address= :address")
	//public List<Customer> findByAddressContaining(@Param("address")String address);
	@Query("SELECT c FROM Customer c WHERE c.address= :address")
	public List<Customer> findByAddress(@Param("address") String address);
//	 @Modifying
//	    @Query("UPDATE Company c SET c.address = :address WHERE c.id = :companyId")
//	    int updateAddress(@Param("companyId") int companyId, @Param("address") String address);
//	 @Modifying
//	 @Query("UPDATE Customer c SET ")
	
}
