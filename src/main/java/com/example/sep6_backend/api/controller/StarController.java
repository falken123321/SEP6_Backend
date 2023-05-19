package com.example.sep6_backend.api.controller;

import com.example.sep6_backend.service.StarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarController {

    private StarsService starsService;

    @Autowired
    public StarController (StarsService starsService) {
        this.starsService = starsService;
    }
    @GetMapping("/getStarsWithMovieId")
    public List<Integer> getStarsWithMovieId(@RequestParam Integer movieId) {
        return starsService.retrieveStarsByMovieId(movieId);
    }
}
