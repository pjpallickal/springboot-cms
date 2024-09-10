package com.cms.transactionservice.service;

import com.cms.transactionservice.entity.Customer;

public interface CustomerService {
    Customer findCustomerById(int id);
    Customer updateCustomer(Customer theCustomer);
    void deleteCustomer(int id);
}
