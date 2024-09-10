package com.cms.authservice.dao;

import com.cms.authservice.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements  UserDAO{

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl (EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public User findUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User authenticate(String userName, String password) {
        TypedQuery<User> theQuery = entityManager.createQuery("from User where userName=:userName", User.class);
        theQuery.setParameter("userName", userName);
        List<User> userList =  theQuery.getResultList();
        if(userList.isEmpty()) {
            return null;
        }
        return userList.getFirst();
    }

    @Override
    public User addUser(User theUser) {
        return entityManager.merge(theUser);
    }

    @Override
    public void deleteUser(int id) {
        User theUser = entityManager.find(User.class, id);
        entityManager.remove(theUser);
    }
}
