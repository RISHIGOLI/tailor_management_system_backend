package com.tailor.admin.customers;

import com.tailor.admin.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseEntity<Response> editCustomer(Long customerId, Customer customerFromClient) {
        if (customerId.toString().isEmpty() || customerId == null){
            return new ResponseEntity<>(new Response(false, HttpStatus.BAD_REQUEST.value(), "Invalid customer id or Empty customer id"), HttpStatus.BAD_REQUEST);
        }

        Optional<Customer> customerFromDB = customerRepository.findById(customerId);
        if (customerFromDB.isPresent()){
            Customer customer = customerFromDB.get();
            if (!customerFromClient.getCustomerName().isEmpty()){
                customer.setCustomerName(customerFromClient.getCustomerName());
            }
            if (!customerFromClient.getCustomerAddress().isEmpty()){
                customer.setCustomerAddress(customerFromClient.getCustomerAddress());
            }
            if (!customerFromClient.getCustomerMobileNo().isEmpty()){
                customer.setCustomerMobileNo(customerFromClient.getCustomerMobileNo());
            }
            if (!customerFromClient.getReferredBy().isEmpty()){
                customer.setReferredBy(customerFromClient.getReferredBy());
            }
            Customer savedCustomer = customerRepository.save(customer);
            if (savedCustomer == null){
                return new ResponseEntity<>(new Response(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong"), HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>(new Response(true, HttpStatus.OK.value(), "Customer edited successfully", Collections.singletonList(savedCustomer)), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Response(false, HttpStatus.NOT_FOUND.value(), "Customer not found"),HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Response> deleteCustomer(Long customerId) {
        if (customerId.toString().isEmpty() || customerId == null){
            return new ResponseEntity<>(new Response(false, HttpStatus.BAD_REQUEST.value(), "invalid customer id"), HttpStatus.BAD_REQUEST);
        }
        Optional<Customer> customerFromDB = customerRepository.findById(customerId);
        if (customerFromDB.isPresent()){
            customerRepository.deleteById(customerId);
            return new ResponseEntity<>(new Response(true, HttpStatus.OK.value(), "customer deleted successfully"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Response(false, HttpStatus.BAD_REQUEST.value(), "Customer not found"), HttpStatus.BAD_REQUEST);
        }
    }
}
