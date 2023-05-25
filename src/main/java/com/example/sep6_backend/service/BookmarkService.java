package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.Bookmark;
import com.example.sep6_backend.api.model.Movie;
import com.example.sep6_backend.repository.BookmarkRepository;
import com.example.sep6_backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private MovieRepository movieRepository;

    public Bookmark saveBookmark(int movie_id,int user_id) {
        Bookmark bm = new Bookmark(movie_id, user_id);
        return bookmarkRepository.saveBookmark(bm);
    }

    public List<Movie> getBookmarksByUser(int user_id) {
        List<Bookmark> bookmarks = bookmarkRepository.getBookmarksByUserId(user_id);

        List<Movie> movies = new ArrayList<>();
        for (Bookmark bookmark : bookmarks) {
            System.out.println(bookmark.getMovie_id());
            Movie movie = movieRepository.getMovieById(bookmark.getMovie_id());
            movies.add(movie);
        }
        return movies;
    }


}
