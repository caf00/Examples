package com.alejandro.relationshipexample.services;

import com.alejandro.relationshipexample.entities.Author;
import com.alejandro.relationshipexample.entities.Book;
import com.alejandro.relationshipexample.entities.Editorial;
import com.alejandro.relationshipexample.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return this.bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public List<Book> getBookByAuthor(Author author) {
        return null;
    }

    public List<Book> getBookByEditorial(Editorial editorial) {
        return null;
    }
}
