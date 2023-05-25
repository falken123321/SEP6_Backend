package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.Movie;
import com.example.sep6_backend.api.model.Review;
import com.example.sep6_backend.repository.MovieRepository;
import com.example.sep6_backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveReview(String comment, float rating, int user_id, int movie_id) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate currentDate = currentDateTime.toLocalDate();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

        Review review = new Review(comment,rating,sqlDate,user_id,movie_id);
        return reviewRepository.saveReview(review);
    }

    public List<Review> getReviewsByMovieId(int movie_id) {
        return reviewRepository.getReviewsByMovieId(movie_id);
    }

}
