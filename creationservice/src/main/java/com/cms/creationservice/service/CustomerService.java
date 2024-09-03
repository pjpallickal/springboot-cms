package com.cms.creationservice.service;

import com.cms.creationservice.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findByID(int id);
    List<Customer> findByName(String searchValue);
    Customer save(Customer theCustomer);
}
