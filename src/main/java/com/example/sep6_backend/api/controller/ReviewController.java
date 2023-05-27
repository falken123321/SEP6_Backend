package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.api.model.Movie;
import com.example.sep6_backend.api.model.Review;
import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.service.ReviewService;
import com.example.sep6_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/createReview")
    public Review createReview(@RequestParam String comment, @RequestParam float rating, @RequestParam int user_id,@RequestParam int movie_id, @RequestParam String title, @RequestParam String image) {
        return reviewService.saveReview(comment,rating,user_id,movie_id,title,image); //userService.saveUser(username, password, email, firstname, lastName);
    }

    @GetMapping("/getReviewByMovieId")
    public List<Review> getReviewByMovieId(@RequestParam int movie_id) {
        return reviewService.getReviewsByMovieId(movie_id);
    }

    @GetMapping("/getReviewByUserId")
    public List<Review> getReviewByUserId(@RequestParam int user_id) {
        return reviewService.getReviewsByUserId(user_id);
    }

    @GetMapping("/getTopRatedMovies")
    public List<Movie> getTopRatedMovies() {
        return reviewService.getTopRatedMovies();
    }



}
