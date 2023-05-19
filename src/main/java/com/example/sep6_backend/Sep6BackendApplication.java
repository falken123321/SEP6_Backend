package com.example.sep6_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication
public class Sep6BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sep6BackendApplication.class, args);


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Query peopleByIdQuery = entityManager.createNativeQuery("SELECT * FROM People p WHERE p.id = :id");
            peopleByIdQuery.setParameter("id", 10);
            List<Object[]> results = peopleByIdQuery.getResultList();

            for (Object[] result : results) {
                // Assuming the query selects all columns from the People table
                int id = (int) result[0];
                String name = (String) result[1];
                java.math.BigInteger birth = (java.math.BigInteger) result[2];

                System.out.println("Person ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Birth: " + birth);
            }

            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.clear();
            entityManagerFactory.close();
        }
    }

}
