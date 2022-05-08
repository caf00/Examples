package com.alejandro.paginationexample.service.contract;

import com.alejandro.paginationexample.entity.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GetAllAnimal {
    Page<Animal> execute(Pageable pageable);
}
