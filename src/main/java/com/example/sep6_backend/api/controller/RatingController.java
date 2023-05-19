package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.api.model.People;
import com.example.sep6_backend.api.model.Ratings;
import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.service.PeopleService;
import com.example.sep6_backend.service.RatingService;
import com.example.sep6_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    private RatingService ratingService;

    @Autowired
    public RatingController (RatingService ratingService) {
        this.ratingService = ratingService;
    }
    @GetMapping("/getRatingWithMovieId")
    public Ratings getRatingWithMovieId(@RequestParam Integer movieId) {
        return ratingService.retrieveRatingByMovieId(movieId);
    }
}
