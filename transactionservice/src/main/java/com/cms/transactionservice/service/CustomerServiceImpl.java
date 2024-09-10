package com.cms.transactionservice.service;

import com.cms.transactionservice.dao.CustomerDAO;
import com.cms.transactionservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl (CustomerDAO theCustomerDAO) {
        customerDAO = theCustomerDAO;
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerDAO.findCustomerById(id);
    }

    @Transactional
    @Override
    public Customer updateCustomer(Customer theCustomer) {
        return customerDAO.updateCustomer(theCustomer);
    }

    @Transactional
    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
}
