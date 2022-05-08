package com.alejandro.relationshipexample.controllers;

import com.alejandro.relationshipexample.entities.Book;
import com.alejandro.relationshipexample.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBook() {
        return ResponseEntity.ok(this.bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(this.bookService.saveBook(book));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        this.bookService.deleteBook(id);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.findByAuthor(id));
    }

    @GetMapping("/editorial/{id}")
    public ResponseEntity<List<Book>> findByEditorial(@PathVariable Long id) {
        this.bookService.findByEditorial(id).forEach(b->System.out.println(b.toString()));
        return ResponseEntity.ok(this.bookService.findByEditorial(id));
    }
}
