package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.People;
import com.example.sep6_backend.api.model.Ratings;
import com.example.sep6_backend.repository.PeopleRepository;
import com.example.sep6_backend.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private RatingRepository ratingRepository;

    @Autowired
    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Ratings retrieveRatingByMovieId(int id) {
        return ratingRepository.getRatingByMovieId(id);
    }
}
