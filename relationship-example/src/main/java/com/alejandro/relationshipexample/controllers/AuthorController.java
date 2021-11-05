package com.alejandro.relationshipexample.controllers;

import com.alejandro.relationshipexample.entities.Author;
import com.alejandro.relationshipexample.entities.Book;
import com.alejandro.relationshipexample.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor() {
        return ResponseEntity.ok(this.authorService.getAllAuthors());
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(this.authorService.saveAuthor(author));
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksForAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(this.authorService.getBookForAuthor(id));
    }
}
