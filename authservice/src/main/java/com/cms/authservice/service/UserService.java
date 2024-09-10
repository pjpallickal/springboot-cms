package com.cms.authservice.service;

import com.cms.authservice.entity.User;

import java.util.List;

public interface UserService {
    User findUserByID(int id);
    User authenticate(String userName, String password);
    User addUser(User theUser);
    void deleteUser(int id);
}
