package com.alejandro.demoSorterPagination.app.usecase;

public class AnimalDto {
    private final Integer id;
    private final String name;

    public AnimalDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static AnimalDto newAnimalDto(Integer id, String name) {
        return new AnimalDto(id, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
