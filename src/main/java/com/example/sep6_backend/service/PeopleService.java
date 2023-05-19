package com.example.sep6_backend.service;

import com.example.sep6_backend.api.model.People;
import com.example.sep6_backend.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    private PeopleRepository peopleRepository;

    @Autowired
    public void setPeopleRepository(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    public People retrievePeopleById(int id) {
        //peopleRepository.findById(id);
        return null;
    }
}
