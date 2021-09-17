package com.alejandro.crud.simplearraycrud.service;

import com.alejandro.crud.simplearraycrud.entity.Person;
import com.alejandro.crud.simplearraycrud.exception.PersonNotFoundException;
import com.alejandro.crud.simplearraycrud.repository.contract.PersonRepository;
import com.alejandro.crud.simplearraycrud.service.contract.GetAgeOfPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class GetAgeOfPersonImpl implements GetAgeOfPerson {

    private final PersonRepository personRepository;

    @Autowired
    public GetAgeOfPersonImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Integer execute(Long id) {
        Optional<Person> personOptional = this.personRepository.findById(id);
        if(personOptional.isEmpty()) throw new PersonNotFoundException("Person not found.");
        Person person = personOptional.get();
        LocalDate now = LocalDate.now();
        LocalDate birthdate = LocalDate.of(
                person.getDateOfBirth().getYear(),
                person.getDateOfBirth().getMonth(),
                person.getDateOfBirth().getDay());
        return Period.between(birthdate, now).getYears();
    }
}
