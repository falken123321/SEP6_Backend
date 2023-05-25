package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserWithId(int id) {
        return userRepository.getUserById(id);
    }

    public User saveUser(String username, String password, String email, String firstname, String lastName) {
        boolean isAdmin = false;
        boolean isBanned = false;
        User u = new User(username, password, email, firstname, lastName, isAdmin,isBanned);
        return userRepository.saveUser(u);
    }

    public User login(String username, String password) {
        return userRepository.login(username, password);
    }
}
