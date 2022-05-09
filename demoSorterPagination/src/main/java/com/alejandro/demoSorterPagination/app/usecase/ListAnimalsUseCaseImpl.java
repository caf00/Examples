package com.alejandro.demoSorterPagination.app.usecase;

import com.alejandro.demoSorterPagination.app.domain.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListAnimalsUseCaseImpl implements ListAnimalsUseCase {

    private final AnimalRepository animalRepository;

    @Autowired
    public ListAnimalsUseCaseImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Page<AnimalDto> execute(Pageable pageable) {
        return animalRepository
                .findAll(pageable)
                .map(a->AnimalDto.newAnimalDto(
                        a.getId(),
                        a.getName()
                ));
    }
}
