package com.alejandro.crud.simplearraycrud.service.contract;

import com.alejandro.crud.simplearraycrud.entity.Person;


public interface GetOnePersonById {
    Person execute(Long id);
}
