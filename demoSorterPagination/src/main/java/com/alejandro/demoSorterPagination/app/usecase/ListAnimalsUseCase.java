package com.alejandro.demoSorterPagination.app.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListAnimalsUseCase {
    Page<AnimalDto> execute(Pageable pageable);
}
