package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.People;
import com.example.sep6_backend.api.model.Ratings;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class RatingRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public Ratings getRatingByMovieId(int id) {
        Query query = entityManager.createNativeQuery("SELECT p.* FROM ratings p WHERE p.movie_id=:id");
        query.setParameter("id", id);
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            int movieId = (int) result[0];
            Float rating = (Float) result[1];
            int votes = (int) result[2];

            return new Ratings(movieId, rating, votes);
        }
        return null;
    }
}
