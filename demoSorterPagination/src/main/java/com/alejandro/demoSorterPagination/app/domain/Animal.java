package com.alejandro.demoSorterPagination.app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    protected Animal() {
    }

    public Animal(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Animal newAnimal(Integer id, String name) {
        return new Animal(id, name);
    }

    public static Animal newAnimal(String name) {
        return new Animal(null, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
