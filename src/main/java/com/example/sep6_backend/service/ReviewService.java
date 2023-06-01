package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.Movie;
import com.example.sep6_backend.api.model.Review;
import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.repository.MovieRepository;
import com.example.sep6_backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    public Review saveReview(String comment, float rating, int user_id, int movie_id,String title, String image) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDate currentDate = currentDateTime.toLocalDate();
        java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

        Review review = new Review(comment,rating,sqlDate,user_id,movie_id);
        try {
            movieService.saveMovie(Long.valueOf(movie_id),title,image);
        } catch (Exception e) {
        }


        return reviewRepository.saveReview(review);
    }

    public List<Review> getReviewsByMovieId(int movie_id) {
        List<Review> reviews = reviewRepository.getReviewsByMovieId(movie_id);
        for (Review review : reviews) {
            User u = userService.getUserWithId(review.getUser_id());
            review.setUsername(u.getUsername());
        }
        return reviews;
    }

    public List<Review> getReviewsByUserId(int user_id) {
        List<Review> reviews = reviewRepository.getReviewsByUserId(user_id);

        for (Review review : reviews) {
            Movie movie = movieRepository.getMovieById(review.getMovie_id());
            review.setImage(movie.getImageString());
            review.setTitle(movie.title);
        }
        return reviews;
    }

    public List<Movie> getTopRatedMovies() {
        List<Movie> movies = new ArrayList<>();
        Map<Integer, Double> map = reviewRepository.getTopRatedMovies(30);

        for (Integer id : map.keySet()) {
            Movie m = movieRepository.getMovieById(id);
            if (m != null) {
                m.setRating(map.get(id).floatValue());
                movies.add(m);
            }
        }
        return movies;
    }
}
