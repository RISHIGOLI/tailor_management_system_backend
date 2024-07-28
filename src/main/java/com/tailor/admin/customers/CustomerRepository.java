package com.tailor.admin.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByCustomerName(String customerName);

    @Query("SELECT c FROM Customer c WHERE c.customerName LIKE %:customerName%")
    List<Customer> findByCustomerNameContaining(@Param("customerName") String customerName);
}
