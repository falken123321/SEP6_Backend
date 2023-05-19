package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.Directors;
import com.example.sep6_backend.api.model.Movies;
import com.example.sep6_backend.api.model.People;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public Movies getMovieById(int id) {
        Query query = entityManager.createNativeQuery("SELECT m.* FROM movies m WHERE m.id=:id");
        query.setParameter("id", id);
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            int movieId = (int) result[0];
            String title = (String) result[1];
            Long year = ((java.math.BigInteger) result[2]).longValue();
            return new Movies(movieId,title,year);
        } return null;
    }
}
