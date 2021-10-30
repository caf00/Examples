package com.alejandro.relationshipexample.controllers;

import com.alejandro.relationshipexample.entities.Editorial;
import com.alejandro.relationshipexample.services.EditorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("editorial")
public class EditorialCotroller {
    private final EditorialService editorialService;

    public EditorialCotroller(EditorialService editorialService) {
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
}
