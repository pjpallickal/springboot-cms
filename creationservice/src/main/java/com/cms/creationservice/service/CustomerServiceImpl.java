package com.cms.creationservice.service;

import com.cms.creationservice.dao.CustomerDAO;
import com.cms.creationservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl (CustomerDAO theCustomerDAO) {
        customerDAO = theCustomerDAO;
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public Customer findByID(int id) {
        return customerDAO.findByID(id);
    }

    @Override
    public List<Customer> findByName(String searchValue) {
        return customerDAO.findByName(searchValue);
    }

    @Transactional
    @Override
    public Customer save(Customer theCustomer) {
        return customerDAO.save(theCustomer);
    }
}
