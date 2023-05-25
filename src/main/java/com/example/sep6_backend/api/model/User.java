package com.example.sep6_backend.api.model;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public", catalog = "postgres")
    public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "lastname")
    private String lastName;

    @Basic
    @Column(name = "isAdmin")
    private boolean isAdmin;

    @Basic
    @Column(name = "banned")
    private boolean banned;

        public User() {

        }

        public User(String username, String password, String email, String firstname, String lastName, boolean isAdmin, boolean banned) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.firstname = firstname;
            this.lastName = lastName;
            this.isAdmin = isAdmin;
            this.banned = banned;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public boolean isAdmin() {
            return isAdmin;
        }

        public void setAdmin(boolean admin) {
            isAdmin = admin;
        }

        public boolean isBanned() {
            return banned;
        }

        public void setBanned(boolean banned) {
            this.banned = banned;
        }

}
