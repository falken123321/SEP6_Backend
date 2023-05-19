package com.example.sep6_backend.api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "people")
public class People {

    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER", name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "birth")
    private Long birth;

    public People(int id, String name, Long birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public People() {

    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getBirth() {
        return birth;
    }

    public void setBirth(Long birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        try {
            return "People{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", birth=" + birth +
                    '}';
        } catch (Exception e) {
            e.printStackTrace();
            return super.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (id != people.id) return false;
        if (name != null ? !name.equals(people.name) : people.name != null) return false;
        if (birth != null ? !birth.equals(people.birth) : people.birth != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        return result;
    }
}
