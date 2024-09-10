package com.cms.authservice.rest;

import com.cms.authservice.entity.User;
import com.cms.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable int userId) {
        User theUser = userService.findUserByID(userId);
        System.out.println("User : " + userId + " is " + theUser);
        if (theUser == null) {
            throw new RuntimeException("User ID not found : " + userId);
        }
        return theUser;
    }

    @PostMapping("/user/login")
    public AuthResponse authenticate( @RequestBody Credentials credentials) {
        User authUser = userService.authenticate(credentials.getUserName(), credentials.getPassword());
        if (authUser == null || !authUser.getUserPassword().equals(credentials.getPassword())) {
            return new AuthResponse( 1 , 0, "Invalid username or password :( ");
        } else {
            return new AuthResponse( 0 , authUser.getUserId(), "Authentication Successful !");
        }
    }

    @PostMapping("/user")
    public User addUser( @RequestBody User theUser) {
        theUser.setUserId(0);
        return userService.addUser(theUser);
    }

    @PutMapping("/user")
    public User updateUser( @RequestBody User theUser) {
        return userService.addUser(theUser);
    }

    @DeleteMapping("/user/{userId}")
    public AuthResponse deleteUser(@PathVariable int userId) {
        User theUser = userService.findUserByID(userId);
        if (theUser == null) {
            //throw new RuntimeException("User ID not found : " + userId);
            return new AuthResponse(1, userId, "Failed to process request.");
        }
        userService.deleteUser(userId);
        return new AuthResponse(0, userId, "User Deleted");
    }
}
