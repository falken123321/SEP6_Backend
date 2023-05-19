package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.People;
import com.example.sep6_backend.api.model.Ratings;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class StarRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public List<Integer> getStarsByMovieId(int id) {
        Query query = entityManager.createNativeQuery("SELECT p.* FROM stars p WHERE p.movie_id=:id");
        query.setParameter("id", id);
        List<Object[]> results = query.getResultList();

        List<Integer> stars = new ArrayList<>();
        for (Object[] result : results) {
            int person_id = (int) result[1];
            stars.add(person_id);
        }
        return stars;
    }
}
