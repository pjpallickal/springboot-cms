package com.cms.authservice.service;

import com.cms.authservice.dao.UserDAO;
import com.cms.authservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl (UserDAO theUserDAO) {
        userDAO = theUserDAO;
    }

    @Override
    public User findUserByID(int id) {
        return userDAO.findUserByID(id);
    }

    @Override
    public User authenticate(String userName, String password) {
        return userDAO.authenticate(userName, password);
    }

    @Transactional
    @Override
    public User addUser(User theUser) {
        return userDAO.addUser(theUser);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
