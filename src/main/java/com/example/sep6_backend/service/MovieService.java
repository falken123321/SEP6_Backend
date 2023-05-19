package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.Movies;
import com.example.sep6_backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public void setPeopleRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movies retrieveMovieById(int movieId) {
        return movieRepository.getMovieById(movieId);
    }
}
