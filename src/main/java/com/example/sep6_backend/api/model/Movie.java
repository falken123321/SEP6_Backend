package com.example.sep6_backend.api.model;

import javax.persistence.*;

@Entity
@Table(name = "movie", schema = "public", catalog = "postgres")
public class Movie {

    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "title")
    public String title;

    public Movie(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
