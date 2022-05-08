package com.alejandro.relationshipexample.services;

import com.alejandro.relationshipexample.entities.Author;
import com.alejandro.relationshipexample.entities.Book;
import com.alejandro.relationshipexample.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAuthor(Author author) {
        return this.authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    public List<Book> getBookForAuthor(Long id) {
        Author author = this.authorRepository.getById(id);
        return author.getBooks();
    }
}
