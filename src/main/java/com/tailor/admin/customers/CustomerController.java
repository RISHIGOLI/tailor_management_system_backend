package com.tailor.admin.customers;

import com.tailor.admin.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/getCustomer")
    public String getCustomer(){
        return  "GOLI RISHI";
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Response> addCustomer(@RequestBody Customer customer){
        return this.customerService.addCustomer(customer);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<Response> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }

    @PutMapping("/editCustomer/{customerId}")
    public ResponseEntity<Response> editCustomer(@PathVariable Long customerId, @RequestBody Customer customer){
        return this.customerService.editCustomer(customerId,customer);
    }

    @PostMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable Long customerId){
        return this.customerService.deleteCustomer(customerId);
    }
}
