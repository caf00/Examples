package com.alejandro.crud.simplearraycrud.service;

import com.alejandro.crud.simplearraycrud.entity.Person;
import com.alejandro.crud.simplearraycrud.repository.contract.PersonRepository;
import com.alejandro.crud.simplearraycrud.service.contract.GetAllPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPersonImpl implements GetAllPerson {

    private final PersonRepository personRepository;

    public GetAllPersonImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> execute() {
        return this.personRepository.getAll();
    }
}
