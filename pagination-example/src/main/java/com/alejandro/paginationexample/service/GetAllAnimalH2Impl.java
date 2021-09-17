package com.alejandro.paginationexample.service;

import com.alejandro.paginationexample.entity.Animal;
import com.alejandro.paginationexample.repository.AnimalRepository;
import com.alejandro.paginationexample.service.contract.GetAllAnimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAnimalH2Impl implements GetAllAnimal {

    private final AnimalRepository animalRepository;

    public GetAllAnimalH2Impl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Page<Animal> execute(Pageable pageable) {
        return this.animalRepository.findAll(pageable);
    }
}
