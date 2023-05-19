package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.User;
import com.example.sep6_backend.api.model.People;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(int id) {
        User u = new User(1, "Tobias", "Tobias@live.dk", "PassWord1");
        return u;
    }

    public People getPeopleWithId(int id) {
        return null;
    }
}
