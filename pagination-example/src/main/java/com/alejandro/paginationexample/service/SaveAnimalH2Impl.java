package com.alejandro.paginationexample.service;

import com.alejandro.paginationexample.entity.Animal;
import com.alejandro.paginationexample.repository.AnimalRepository;
import com.alejandro.paginationexample.service.contract.SaveAnimal;
import org.springframework.stereotype.Service;

@Service
public class SaveAnimalH2Impl implements SaveAnimal {

    private final AnimalRepository animalRepository;

    public SaveAnimalH2Impl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void execute(Animal animal) {
        this.animalRepository.save(animal);
    }
}
