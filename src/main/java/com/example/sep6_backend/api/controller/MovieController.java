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
    public Movie createMovie(@RequestParam Integer id, @RequestParam String title, @RequestParam String imageString) {
        return movieService.saveMovie(Long.parseLong(id.toString()),title,imageString);
    }

    @GetMapping("/getMovie")
    public Movie getMovie(@RequestParam Integer id) {
        return movieService.getMovie(id);
    }

    @GetMapping("/getMoviesFromSearch")
    public List<Movie> getMoviesFromSearch(@RequestParam String searchString) {
        return movieService.getMoviesFromSearch(searchString);
    }


}
