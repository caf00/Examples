package com.alejandro.paginationexample.controller;

import com.alejandro.paginationexample.entity.Animal;
import com.alejandro.paginationexample.response.AnimalResponse;
import com.alejandro.paginationexample.service.contract.GetAllAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final GetAllAnimal getAllAnimal;

    public AnimalController(GetAllAnimal getAllAnimal) {
        this.getAllAnimal = getAllAnimal;
    }

    @GetMapping
    public ResponseEntity<AnimalResponse> getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        Page<Animal> animals = this.getAllAnimal.execute(PageRequest.of(page, size));
        return ResponseEntity.ok(this.convertToAnimalResponse(animals));
    }

    private AnimalResponse convertToAnimalResponse(Page<Animal> page) {
        return new AnimalResponse(
                page.getContent(),
                page.isFirst(),
                page.isLast(),
                page.getTotalPages(),
                page.getNumberOfElements(),
                page.getNumber(),
                page.isEmpty()
        );
    }
}
