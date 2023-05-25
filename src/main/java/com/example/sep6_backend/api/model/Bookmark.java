package com.example.sep6_backend.api.model;

import javax.persistence.*;

@Entity
@Table(name = "bookmark", schema = "public", catalog = "postgres")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "movie_id")
    public Integer movie_id;

    @Column(name = "user_id")
    public Integer user_id;

    public Bookmark(Integer movie_id, Integer user_id) {
        this.movie_id = movie_id;
        this.user_id = user_id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
