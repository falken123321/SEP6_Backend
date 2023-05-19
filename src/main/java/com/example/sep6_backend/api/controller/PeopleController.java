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
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController (PeopleService peopleService) {
        this.peopleService = peopleService;
    }
    @GetMapping("/getPeopleWithId")
    public People getUser(@RequestParam Integer id) {
        return peopleService.retrievePeopleById(id);
    }
}
