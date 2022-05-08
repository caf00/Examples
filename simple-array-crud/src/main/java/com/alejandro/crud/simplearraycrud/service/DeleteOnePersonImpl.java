package com.alejandro.crud.simplearraycrud.service;

import com.alejandro.crud.simplearraycrud.exception.PersonNotFoundException;
import com.alejandro.crud.simplearraycrud.repository.contract.PersonRepository;
import com.alejandro.crud.simplearraycrud.service.contract.DeleteOnePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteOnePersonImpl implements DeleteOnePerson {

    private final PersonRepository personRepository;

    @Autowired
    public DeleteOnePersonImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void execute(Long id) {
        if(!this.personRepository.existById(id))
            throw new PersonNotFoundException("Person not found.");
        this.personRepository.delete(id);
    }
}
