package com.alejandro.demoSorterPagination.app.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    Page<Animal> findAll(Pageable pageable);
}
