package com.tailor.admin.customers;

import com.tailor.admin.utils.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    ResponseEntity<Response> addCustomer(Customer customer);

    ResponseEntity<Response> getAllCustomers();

    ResponseEntity<Response> editCustomer(Long customerId, Customer customer);
}
