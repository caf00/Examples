package com.alejandro.relationshipexample.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int pages;
    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private Book() {
    }

    public Book(String title, int pages, Editorial editorial, Author author) {
        this.title = title;
        this.pages = pages;
        this.editorial = editorial;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public Author getAuthor() {
        return author;
    }
}
