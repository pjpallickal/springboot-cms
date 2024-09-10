package com.cms.transactionservice.rest;

import com.cms.transactionservice.entity.Customer;
import com.cms.transactionservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private CustomerService customerService;

    @Autowired
    public CustomerRestController (CustomerService theCustomerService) {
        customerService = theCustomerService;
    }

    @PutMapping("/customers")
    public Customer updateUser(@RequestBody Customer theCustomer) {
        return customerService.updateCustomer(theCustomer);
    }

    @DeleteMapping("/customers/{customerId}")
    public Response deleteUser(@PathVariable int customerId) {
        Customer theCustomer = customerService.findCustomerById(customerId);
        if (theCustomer == null) {
            //throw new RuntimeException("User ID not found : " + userId);
            return new Response(1, customerId, "Failed to process request.");
        }
        customerService.deleteCustomer(customerId);
        return new Response(0, customerId, "Customer Deleted");
    }
}
