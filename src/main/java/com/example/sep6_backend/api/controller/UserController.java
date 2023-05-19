package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getUserWithId")
    public User getUser(@RequestParam Integer id) {
        return userService.getUser(id);
    }

}
