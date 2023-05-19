package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.Directors;
import com.example.sep6_backend.repository.DirectorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorsService {
    private DirectorsRepository directorsRepository;

    @Autowired
    public void setPeopleRepository(DirectorsRepository directorsRepository) {
        this.directorsRepository = directorsRepository;
    }

    public List<Integer> retrieveDirectorById(int movieId) {
        return directorsRepository.getDirectorById(movieId);
    }
}
