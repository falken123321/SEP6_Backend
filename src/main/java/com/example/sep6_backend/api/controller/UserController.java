package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam String firstname, @RequestParam String lastName) {
        if (userService.userExistsWithUsername(username)) {
            return null;
        }
        return userService.saveUser(username, password, email, firstname, lastName);
    }

    @GetMapping("/login")
    public User createUser(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @GetMapping("/getUserWithId")
    public User getUserWithId(@RequestParam int id) {
        return userService.getUserWithId(id);
    }



}
