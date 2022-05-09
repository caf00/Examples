package com.alejandro.demoSorterPagination.web;

import com.alejandro.demoSorterPagination.app.usecase.AnimalDto;
import com.alejandro.demoSorterPagination.app.usecase.ListAnimalsUseCase;
import com.alejandro.demoSorterPagination.web.response.AnimalResponse;
import com.alejandro.demoSorterPagination.web.response.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final ListAnimalsUseCase listAnimalsUseCase;
    private final PageableBuilder pageableBuilder;

    @Autowired
    public AnimalController(ListAnimalsUseCase listAnimalsUseCase,
                            PageableBuilder pageableBuilder) {
        this.listAnimalsUseCase = listAnimalsUseCase;
        this.pageableBuilder = pageableBuilder;
    }

    @GetMapping
    public ResponseEntity<ListResponse<AnimalResponse>> list(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "id") String sort,
            @RequestParam(required = false, defaultValue = "asc") String order
    ) {
        Pageable pageable = pageableBuilder.generatePageable(page, size, sort, order);
        Page<AnimalDto> animalDtoPage = listAnimalsUseCase.execute(pageable);
        List<AnimalResponse> animalResponseList = animalDtoPage
                .get()
                .map(a->AnimalResponse.newAnimalResponse(
                        a.getId(),
                        a.getName()
                ))
                .collect(Collectors.toList());
        ListResponse<AnimalResponse> listResponse = ListResponse.newListResponse(
                animalDtoPage.getNumber()+1,
                animalDtoPage.getTotalPages(),
                animalDtoPage.getNumberOfElements(),
                animalDtoPage.hasNext(),
                animalDtoPage.hasPrevious(),
                animalResponseList
        );
        return ResponseEntity.ok(listResponse);
    }

}
