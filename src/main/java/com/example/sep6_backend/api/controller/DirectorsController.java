package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.api.model.Directors;
import com.example.sep6_backend.api.model.People;
import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.service.DirectorsService;
import com.example.sep6_backend.service.PeopleService;
import com.example.sep6_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectorsController {

    private DirectorsService directorsService;

    @Autowired
    public DirectorsController (DirectorsService directorsService) {
        this.directorsService = directorsService;
    }
    @GetMapping("/getAllDirectorWithMovieId")
    public List<Integer> getAllDirectorWithMovieId(@RequestParam Integer movieId) { //TODO: Prob should add something that returns the People object.
        return directorsService.retrieveDirectorById(movieId);
    }
}
