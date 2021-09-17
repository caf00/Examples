package com.alejandro.paginationexample.repository;

import com.alejandro.paginationexample.entity.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Page<Animal> findAll(Pageable pageable);
}
