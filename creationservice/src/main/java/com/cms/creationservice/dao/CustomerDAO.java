package com.cms.creationservice.dao;

import com.cms.creationservice.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();
    Customer findByID(int id);
    List<Customer> findByName(String searchValue);
    Customer save(Customer theCustomer);
}
