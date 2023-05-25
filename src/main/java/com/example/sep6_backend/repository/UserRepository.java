package com.example.sep6_backend.repository;

import com.example.sep6_backend.api.model.User;
import org.springframework.stereotype.*;
import javax.persistence.*;
import javax.transaction.*;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public User getUserById(int id) {
        Query query = entityManager.createNativeQuery("SELECT u.* FROM User u where u.id=:id"); //SELECT p.* FROM User p WHERE p.id=:id
        query.setParameter("id", id);
        List<Object[]> results = query.getResultList();

        List<User> users = new ArrayList<>();
        for (Object[] result : results) {
            //int person_id = (int) result[1];
            //MAKE A USER;
            users.add(null);
        }
        return users.get(0);
    }

    public User saveUser(User user) {
        try {
            entityManager.persist(user);
            System.out.println("User saved successfully!");
            return user;
        } catch (Exception e) {
            System.out.println("Error: Unable to save user.");
            e.printStackTrace();
            return null;
        }
    }

    public User login(String username, String password) {
        Query query = entityManager.createNativeQuery("SELECT u.* FROM \"user\" u where u.\"username\"=:username and u.\"password\"=:password"); //SELECT p.* FROM User p WHERE p.id=:id
        query.setParameter("username", username);
        query.setParameter("password", password);
        List<Object[]> results = query.getResultList();

        List<User> users = new ArrayList<>();
        for (Object[] result : results) {
            String _username = (String) result[0];// = username;
            String _password = (String) result[1];
            String email = (String) result[2];
            String firstname = (String) result[3];
            String lastName = (String) result[4];
            boolean isAdmin = (boolean) result[5];
            boolean banned = (boolean) result[6];
            Long id = Long.parseLong(result[7].toString());
            User retUser = new User(_username,_password,email,firstname,lastName,isAdmin,banned);
            retUser.id = id;
            return retUser;
        }
        return null;
    }


}
