package com.cms.transactionservice.dao;

import com.cms.transactionservice.entity.Customer;

public interface CustomerDAO {
    Customer findCustomerById(int id);
    Customer updateCustomer(Customer theCustomer);
    void deleteCustomer(int id);
}
