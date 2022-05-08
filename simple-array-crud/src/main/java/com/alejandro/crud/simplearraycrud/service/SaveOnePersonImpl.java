package com.alejandro.crud.simplearraycrud.service;

import com.alejandro.crud.simplearraycrud.entity.Person;
import com.alejandro.crud.simplearraycrud.exception.PersonAlreadyExistException;
import com.alejandro.crud.simplearraycrud.repository.contract.PersonRepository;
import com.alejandro.crud.simplearraycrud.service.contract.SaveOnePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveOnePersonImpl implements SaveOnePerson {

    private final PersonRepository personRepository;

    @Autowired
    public SaveOnePersonImpl(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }

    @Override
    public Person execute(Person person) {
        if(this.personRepository.existById(person.getId()))
            throw new PersonAlreadyExistException("Person already exist.");
        return this.personRepository.save(person);
    }
}
