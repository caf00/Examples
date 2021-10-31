package com.alejandro.crud.simplearraycrud.repository;

import com.alejandro.crud.simplearraycrud.entity.DateOfBirth;
import com.alejandro.crud.simplearraycrud.entity.Person;
import com.alejandro.crud.simplearraycrud.repository.contract.PersonRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final List<Person> personList;

    public PersonRepositoryImpl() {
        personList = new ArrayList<>();
        personList.add(new Person(12345678L, "Alejandro Fernández", new DateOfBirth(13,12,1982)));
        personList.add(new Person(87654321L, "Marcela Fernández", new DateOfBirth(11,10,1987)));
        personList.add(new Person(15151515L, "Pedro Zinni", new DateOfBirth(9,12,1980)));
        personList.add(new Person(45326789L, "Daniela Fernández", new DateOfBirth(1,4,1990)));
        personList.add(new Person(15623456L, "Alexis Hernández", new DateOfBirth(24,5,1984)));
        personList.add(new Person(98563426L, "Daniel Zinni", new DateOfBirth(21,8,1986)));
    }

    @Override
    public List<Person> getAll() {
        return this.personList;
    }

    @Override
    public List<Person> getListByName(String name) {
        return personList
                .stream()
                .filter(p-> p.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personList
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public Person save(Person person) {
        this.personList.add(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        return this.personList
                .stream()
                .filter(p -> p.getId().equals(person.getId()))
                .findFirst()
                .map(p -> {
                    p.setName(person.getName());
                    p.setDateOfBirth(person.getDateOfBirth());
                    return p;
                }).get();
    }

    @Override
    public boolean existById(Long id) {
        Optional<Person> personOptional = this.findById(id);
        return personOptional.isPresent();
    }

    @Override
    public void delete(Long id) {
        this.personList.removeIf(p -> p.getId().equals(id));
    }
}
