package com.alejandro.crud.simplearraycrud.repository.contract;

import com.alejandro.crud.simplearraycrud.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<Person> getAll();
    List<Person> getListByName(String name);
    Optional<Person> findById(Long id);
    Person save(Person person);
    Person update(Person person);
    boolean existById(Long id);
    void delete(Long id);
}
