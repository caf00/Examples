package com.alejandro.relationshipexample.services;

import com.alejandro.relationshipexample.entities.Author;
import com.alejandro.relationshipexample.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAhuthor(Author author) {
        return this.authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }
}
