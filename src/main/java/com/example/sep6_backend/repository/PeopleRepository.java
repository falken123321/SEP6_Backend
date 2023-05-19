package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.People;
import com.example.sep6_backend.persistence.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class PeopleRepository {

/*
    public People findById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TypedQuery<People> PeopleByIdQuery = entityManager.createNamedQuery("SELECT * FROM")

        } finally {
            if()
        }



        return result;
    }


    public People findById(int id) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;
        People result = null;

        try (Session session = sessionFactory.openSession()) {
            System.out.println("Searching for person with id: " + id);
            transaction = session.beginTransaction();

            String hql = "FROM People p WHERE p.id = :id";
            Query<People> query = session.createQuery(hql);
            query.setParameter("id", id);
            result = query.uniqueResult();

            System.out.println("Found result: " + result);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // or use a logger
        }

        return result;
    }*/
}
