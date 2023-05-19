package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.People;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class PeopleRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public People getPeopleById(int id) {
        Query query = entityManager.createNativeQuery("SELECT p.* FROM people p WHERE id=:id");
        query.setParameter("id", id);

        List<Object[]> results = query.getResultList();


        for (Object[] result : results) {
            // Assuming the query selects all columns from the People table
            int personId = (int) result[0];
            String name = (String) result[1];
            java.math.BigInteger birth = (java.math.BigInteger) result[2];

            return new People(personId, name, birth.longValue());
        }
        return null;
    }
}
