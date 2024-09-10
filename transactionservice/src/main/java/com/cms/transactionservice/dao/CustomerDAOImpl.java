package com.cms.transactionservice.dao;

import com.cms.transactionservice.entity.Customer;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl (EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public Customer findCustomerById(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public Customer updateCustomer(Customer theCustomer) {
        return entityManager.merge(theCustomer);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer theCustomer = entityManager.find(Customer.class, id);
        entityManager.remove(theCustomer);
    }
}
