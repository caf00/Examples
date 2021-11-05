package com.alejandro.relationshipexample.services;

import com.alejandro.relationshipexample.entities.Author;
import com.alejandro.relationshipexample.entities.Book;
import com.alejandro.relationshipexample.entities.Editorial;
import com.alejandro.relationshipexample.repositories.AuthorRepository;
import com.alejandro.relationshipexample.repositories.BookRepository;
import com.alejandro.relationshipexample.repositories.EditorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EditorialRepository editorialRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, EditorialRepository editorialRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.editorialRepository = editorialRepository;
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

    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }

    public List<Book> findByAuthor(Long id) {
        Author author = this.authorRepository.getById(id);
        return this.bookRepository.findByAuthor(author);
    }

    public List<Book> findByEditorial(Long id) {
        Editorial editorial = this.editorialRepository.getById(id);
        return this.bookRepository.findByEditorial(editorial);
    }
}
