package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.api.model.Bookmark;
import com.example.sep6_backend.api.model.Movie;
import com.example.sep6_backend.service.BookmarkService;
import com.example.sep6_backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookmarkController {

    private MovieService movieService;
    private BookmarkService bookmarkService;


    @Autowired
    public BookmarkController(MovieService movieService, BookmarkService bookmarkService) {
        this.movieService = movieService;
        this.bookmarkService = bookmarkService;
    }
    @PostMapping("/createBookmarkAndSaveBook")
    public Bookmark createBookmark(@RequestParam Integer movie_id, @RequestParam Integer user_id, @RequestParam String title) {
        try {
            movieService.saveMovie(Long.parseLong(movie_id.toString()),title);
        } finally {
            return bookmarkService.saveBookmark(movie_id,user_id);
        }
    }

    @GetMapping("/getBookmarksByUserId")
    public List<Movie> createBookmark(@RequestParam Integer user_id) {
        return bookmarkService.getBookmarksByUser(user_id);

    }

}
