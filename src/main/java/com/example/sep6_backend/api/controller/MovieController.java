package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.api.model.Directors;
import com.example.sep6_backend.api.model.Movies;
import com.example.sep6_backend.api.model.People;
import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.service.DirectorsService;
import com.example.sep6_backend.service.MovieService;
import com.example.sep6_backend.service.PeopleService;
import com.example.sep6_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController (MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/getMovieWithId")
    public Movies getAllDirectorWithMovieId(@RequestParam Integer movieId) {
        return movieService.retrieveMovieById(movieId);
    }
}
