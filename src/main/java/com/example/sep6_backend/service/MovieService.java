package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.Movie;
import com.example.sep6_backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Long id, String title, String imageString) {
        Movie m = new Movie(id, title, imageString);

        return movieRepository.saveMovie(m);
    }

    public Movie getMovie(int id) {
        return movieRepository.getMovieById(id);
    }

    public List<Movie> getMoviesFromSearch(String input) {
        return movieRepository.getMoviesByTitle(input);
    }

}
