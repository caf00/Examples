package com.alejandro.crud.simplearraycrud.service.contract;

import com.alejandro.crud.simplearraycrud.entity.Person;

import java.util.List;

public interface GetListPersonByName {
    List<Person> execute(String name);
}
