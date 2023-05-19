package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.api.model.People;
import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.service.PeopleService;
import com.example.sep6_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;
    private PeopleService peopleService;

    @Autowired
    public UserController(UserService userService, PeopleService peopleService) {
        this.userService = userService;
        this.peopleService = peopleService;
    }


    @GetMapping("/getUserWithId")
    public People getUser(@RequestParam Integer id) {
        return peopleService.retrievePeopleById(id);
        //userService.getUser(id);
    }

}
