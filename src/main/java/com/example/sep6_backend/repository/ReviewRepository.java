package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.Movie;
import com.example.sep6_backend.api.model.Review;
import com.example.sep6_backend.api.model.User;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.*;
import javax.persistence.*;
import javax.transaction.*;
import java.nio.DoubleBuffer;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class ReviewRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Review saveReview(Review review) {
        try {
            entityManager.persist(review);
            System.out.println("Review saved successfully!");
            return review;
        } catch (Exception e) {
            System.out.println("Error: Unable to save review.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Review> getReviewsByMovieId(int movie_id) {
        Query query = entityManager.createNativeQuery("SELECT r.* FROM review r WHERE r.movie_id=:movie_id");
        query.setParameter("movie_id", movie_id);
        List<Object[]> results = query.getResultList();

        List<Review> reviews = new ArrayList<>();
        for (Object[] result : results) {
            int id = (int) result[0];
            String comment = (String) result[1];
            float rating = ((Double) result[2]).floatValue();
            java.sql.Date date = (Date) result[3];
            int user_id = (int) result[4];

            reviews.add(new Review(id,comment,rating,date,user_id,movie_id));
        }
        return reviews;
    }

    public List<Review> getReviewsByUserId(int user_id) {
        Query query = entityManager.createNativeQuery("SELECT r.* FROM review r WHERE r.user_id=:user_id");
        query.setParameter("user_id", user_id);
        List<Object[]> results = query.getResultList();

        List<Review> reviews = new ArrayList<>();
        for (Object[] result : results) {
            int id = (int) result[0];
            String comment = (String) result[1];
            float rating = ((Double) result[2]).floatValue();
            java.sql.Date date = (Date) result[3];
            int movie_id = (int) result[5];

            reviews.add(new Review(id,comment,rating,date,user_id,movie_id));
        }
        return reviews;
    }

    public Map<Integer, Double> getTopRatedMovies(int limit) {
        Query query = entityManager.createQuery("SELECT r.movie_id, AVG(r.rating) " +
                "FROM Review r " +
                "GROUP BY r.movie_id " +
                "ORDER BY AVG(r.rating) DESC");
        query.setMaxResults(limit);

        List<Object[]> results = query.getResultList();
        Map<Integer, Double> topRatedMovies = new LinkedHashMap<>();

        for (Object[] result : results) {
            Integer movieId = (Integer) result[0];
            Double averageRating = (Double) result[1];
            topRatedMovies.put(movieId, averageRating);
        }

        return topRatedMovies;
    }


}
