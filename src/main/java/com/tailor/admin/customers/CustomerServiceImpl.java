package com.tailor.admin.customers;

import com.tailor.admin.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<Response> addCustomer(Customer customer) {
        if (customer == null){
            return null;
        }
        Customer savedCustomer = customerRepository.save(customer);
        if (savedCustomer != null){
            return new ResponseEntity<>(new Response(false, HttpStatus.BAD_REQUEST.value(), "customer couldn't be added"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new Response(true, HttpStatus.CREATED.value(),"customer added successfully", Collections.singletonList(savedCustomer)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Response> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty() || customers == null){
            return new ResponseEntity<>(new Response<>(false, HttpStatus.OK.value(), "No customers availale"), HttpStatus.OK);
        }

         return new ResponseEntity<>(new Response(true, HttpStatus.OK.value(), "Query Successful", customers), HttpStatus.OK);
    }
}
