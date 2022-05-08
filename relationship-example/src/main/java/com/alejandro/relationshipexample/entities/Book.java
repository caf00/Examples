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
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "editorial_id", nullable = false)
    private Editorial editorial;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    protected Book() {
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", editorial=" + editorial.getName() +
                ", author=" + author.getName() +
                '}';
    }
}
