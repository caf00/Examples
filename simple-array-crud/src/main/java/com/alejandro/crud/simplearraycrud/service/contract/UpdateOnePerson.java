package com.alejandro.crud.simplearraycrud.service.contract;

import com.alejandro.crud.simplearraycrud.entity.Person;

import java.util.Optional;

public interface UpdateOnePerson {
    Person execute(Person person);
}
