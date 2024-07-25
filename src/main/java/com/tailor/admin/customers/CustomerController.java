package com.tailor.admin.customers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @GetMapping("/getCustomer")
    public String getCustomer(){
        return  "GOLI RISHI";
    }
}
