package com.alejandro.crud.simplearraycrud.service;

import com.alejandro.crud.simplearraycrud.entity.Person;
import com.alejandro.crud.simplearraycrud.exception.PersonNotFoundException;
import com.alejandro.crud.simplearraycrud.repository.contract.PersonRepository;
import com.alejandro.crud.simplearraycrud.service.contract.UpdateOnePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateOnePeronImpl implements UpdateOnePerson {

    private final PersonRepository personRepository;

    @Autowired
    public UpdateOnePeronImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person execute(Person person) {
        if(!this.personRepository.existById(person.getId()))
            throw new PersonNotFoundException("Person not found.");
        return this.personRepository.update(person);
    }
}
