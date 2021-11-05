package com.alejandro.relationshipexample.controllers;

import com.alejandro.relationshipexample.entities.Book;
import com.alejandro.relationshipexample.entities.Editorial;
import com.alejandro.relationshipexample.services.EditorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("editorial")
public class EditorialController {
    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping
    public ResponseEntity<List<Editorial>> getAllEditorial() {
        return ResponseEntity.ok(this.editorialService.getAllEditorial());
    }

    @PostMapping
    public ResponseEntity<Editorial> saveEditorial(@RequestBody Editorial editorial) {
        return ResponseEntity.ok(this.editorialService.saveEditorials(editorial));
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksForEditorial(@PathVariable Long id) {
        return ResponseEntity.ok(this.editorialService.getBookForEditorial(id));
    }
}
