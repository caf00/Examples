package com.alejandro.crud.simplearraycrud.service;

import com.alejandro.crud.simplearraycrud.entity.Person;
import com.alejandro.crud.simplearraycrud.exception.PersonNotFoundException;
import com.alejandro.crud.simplearraycrud.repository.contract.PersonRepository;
import com.alejandro.crud.simplearraycrud.service.contract.GetOnePersonById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOnePersonByIdImpl implements GetOnePersonById {
    private final PersonRepository personRepository;

    @Autowired
    public GetOnePersonByIdImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person execute(Long id) {
        Optional<Person> personOptional =  this.personRepository.findById(id);
        if(personOptional.isEmpty()) throw new PersonNotFoundException("Person not found");
        return personOptional.get();
    }
}
