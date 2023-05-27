package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.Movie;
import org.springframework.stereotype.*;
import javax.persistence.*;
import javax.transaction.*;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Movie> getMoviesByTitle(String title) {
        Query query = entityManager.createNativeQuery("SELECT * FROM movie WHERE LOWER(title) LIKE LOWER(:title)");
        query.setParameter("title", "%" + title.toLowerCase() + "%");
        List<Object[]> results = query.getResultList();

        List<Movie> movies = new ArrayList<>();
        for (Object[] result : results) {
            Movie movie = new Movie(Long.parseLong(result[1].toString()), (String) result[0],(String) result[2]);
            movies.add(movie);
        }
        return movies;
    }

    public Movie getMovieById(int id) {
        Query query = entityManager.createNativeQuery("SELECT u.* FROM movie u where u.id=:id");
        query.setParameter("id", id);
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            Movie m = new Movie(Long.parseLong(result[1].toString()),(String) result[0],(String) result[2]);
            return m;
        }
        return null;
    }

    public Movie saveMovie(Movie movie) {
        try {
            entityManager.persist(movie);
            System.out.println("Movie saved successfully!");
            return movie;
        } catch (Exception e) {
            return null;
        }
    }


}
