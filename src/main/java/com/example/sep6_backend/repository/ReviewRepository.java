package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.Movie;
import com.example.sep6_backend.api.model.Review;
import com.example.sep6_backend.api.model.User;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.*;
import javax.persistence.*;
import javax.transaction.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


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
            float rating = (float) result[2];
            java.sql.Date date = (Date) result[3];
            int user_id = (int) result[4];

            reviews.add(new Review(id,comment,rating,date,user_id,movie_id));
        }
        return reviews;
    }

}
