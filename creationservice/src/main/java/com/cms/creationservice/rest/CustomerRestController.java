package com.cms.creationservice.rest;

import com.cms.creationservice.dao.CustomerDAO;
import com.cms.creationservice.entity.Customer;
import com.cms.creationservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService theCustomerService) {
        customerService = theCustomerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer findById(@PathVariable int customerId) {
        Customer theCustomer = customerService.findByID(customerId);

        if (theCustomer == null) {
            throw new RuntimeException("Customer ID not found : " + customerId);
        }

        return theCustomer;
    }

    @GetMapping("/customers/search")
    public List<Customer> findByName(@RequestParam("query") String searchValue) {
        return customerService.findByName(searchValue);
    }

    @PostMapping("/customers")
    public Customer addCustomer( @RequestBody Customer theCustomer) {
        theCustomer.setCustomerId(0);
        return customerService.save(theCustomer);
    }
}
