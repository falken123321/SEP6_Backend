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

    @Column(name = "image")
    public String imageString;

    @Transient
    public float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Movie(Long id, String title, String imageString) {
        this.id = id;
        this.title = title;
        this.imageString = imageString;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }
}
