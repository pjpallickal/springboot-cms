package com.cms.creationservice.dao;

import com.cms.creationservice.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    private EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl( EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> theQuery = entityManager.createQuery("from Customer", Customer.class);
        return theQuery.getResultList();
    }

    @Override
    public Customer findByID(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findByName(String searchValue) {
        TypedQuery<Customer> theQuery = entityManager.createQuery("from Customer where customerName like CONCAT(:searchValue, '%')", Customer.class);
        theQuery.setParameter("searchValue", searchValue);
        return theQuery.getResultList();
    }

    @Override
    public Customer save(Customer theCustomer) {
        return entityManager.merge(theCustomer);
    }
}
