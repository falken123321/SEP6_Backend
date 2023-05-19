package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.Ratings;
import com.example.sep6_backend.repository.RatingRepository;
import com.example.sep6_backend.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarsService {
    private StarRepository starRepository;

    @Autowired
    public void setRatingRepository(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    public List<Integer> retrieveStarsByMovieId(int id) {
        return starRepository.getStarsByMovieId(id);
    }
}
