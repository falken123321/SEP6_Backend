package com.example.sep6_backend.api.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "review", schema = "public", catalog = "postgres")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "comment")
    public String comment;

    @Column(name = "rating")
    public float rating;

    @Column(name = "date")
    public Date date;

    @Column(name = "user_id")
    public int user_id;

    @Column(name = "movie_id")
    public int movie_id;

    @Transient
    public String username;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Review(String comment, float rating, Date date, int user_id, int movie_id) {
        this.comment = comment;
        this.rating = rating;
        this.date = date;
        this.user_id = user_id;
        this.movie_id = movie_id;
    }

    public Review(int id, String comment, float rating, Date date, int user_id, int movie_id) {
        this(comment, rating, date, user_id, movie_id); // Invoking the first constructor
        this.id = id;
    }
}
