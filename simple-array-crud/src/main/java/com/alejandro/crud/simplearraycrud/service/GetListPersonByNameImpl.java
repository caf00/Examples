package com.alejandro.crud.simplearraycrud.service;

import com.alejandro.crud.simplearraycrud.entity.Person;
import com.alejandro.crud.simplearraycrud.exception.PersonNotFoundException;
import com.alejandro.crud.simplearraycrud.repository.contract.PersonRepository;
import com.alejandro.crud.simplearraycrud.service.contract.GetListPersonByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListPersonByNameImpl implements GetListPersonByName {
    private final PersonRepository personRepository;

    @Autowired
    public GetListPersonByNameImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> execute(String name) {
        List<Person> personList = personRepository.getListByName(name);
        if (personList.isEmpty()) throw new PersonNotFoundException("Person list is empty.");
        return personList;
    }
}
