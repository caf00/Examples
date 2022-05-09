package com.alejandro.demoSorterPagination.web.response;


public class AnimalResponse {
    private final Integer id;
    private final String name;

    public AnimalResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static AnimalResponse newAnimalResponse(Integer id, String name) {
        return new AnimalResponse(id, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
