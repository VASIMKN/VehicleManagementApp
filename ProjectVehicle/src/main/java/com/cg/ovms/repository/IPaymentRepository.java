package com.cg.ovms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ovms.entities.Payment;
@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Integer> {


}
