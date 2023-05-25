package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.api.model.Movie;
import com.example.sep6_backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @PostMapping("/createMovie")
    public Movie createUser(@RequestParam Integer id, @RequestParam String title) {
        return movieService.saveMovie(Long.parseLong(id.toString()),title);
    }

    @GetMapping("/getMovie")
    public Movie createUser(@RequestParam Integer id) {
        return movieService.getMovie(id);
    }

    @GetMapping("/getMoviesFromSearch")
    public List<Movie> createUser(@RequestParam String searchString) {
        return movieService.getMoviesFromSearch(searchString);
    }

/*
    @PostMapping("/createUser")
    public User createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, @RequestParam String firstname, @RequestParam String lastName) {
        return userService.saveUser(username, password, email, firstname, lastName);
    }

    @GetMapping("/login")
    public User createUser(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }
*/


}
