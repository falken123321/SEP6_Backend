package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.Directors;
import com.example.sep6_backend.api.model.People;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class DirectorsRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public List<Integer> getDirectorById(int movie_id) {
        Query query = entityManager.createNativeQuery("SELECT p.* FROM directors p WHERE p.movie_id=:movie_id");
        query.setParameter("movie_id", movie_id);

        List<Object[]> results = query.getResultList();

        List<Integer> returnList = new ArrayList<>();
        for (Object[] result : results) {
            int personId = (int) result[1]; //Dobbelttjek det er rigtig rækkefølge!!
            returnList.add(personId);

        }
        return returnList;
    }
}
