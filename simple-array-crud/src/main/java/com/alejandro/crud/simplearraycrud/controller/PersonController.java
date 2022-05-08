package com.alejandro.crud.simplearraycrud.controller;

import com.alejandro.crud.simplearraycrud.entity.Person;
import com.alejandro.crud.simplearraycrud.response.DataListResponse;
import com.alejandro.crud.simplearraycrud.response.DataObjectResponse;
import com.alejandro.crud.simplearraycrud.response.DataAgeResponse;
import com.alejandro.crud.simplearraycrud.response.ErrorResponse;
import com.alejandro.crud.simplearraycrud.service.contract.DeleteOnePerson;
import com.alejandro.crud.simplearraycrud.service.contract.GetAllPerson;
import com.alejandro.crud.simplearraycrud.service.contract.GetListPersonByName;
import com.alejandro.crud.simplearraycrud.service.contract.GetOnePersonById;
import com.alejandro.crud.simplearraycrud.service.contract.GetAgeOfPerson;
import com.alejandro.crud.simplearraycrud.service.contract.SaveOnePerson;
import com.alejandro.crud.simplearraycrud.service.contract.UpdateOnePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final GetAllPerson getAllPerson;
    private final SaveOnePerson saveOnePerson;
    private final GetListPersonByName getListPersonByName;
    private final GetOnePersonById getOnePersonById;
    private final UpdateOnePerson updateOnePerson;
    private final GetAgeOfPerson getYearOfBirth;
    private final DeleteOnePerson deleteOnePerson;

    @Autowired
    public PersonController(GetAllPerson getAllPerson, SaveOnePerson saveOnePerson, GetListPersonByName getListPersonByName, GetOnePersonById getOnePersonById, UpdateOnePerson updateOnePerson, GetAgeOfPerson getYearOfBirth, DeleteOnePerson deleteOnePerson) {
        this.getAllPerson = getAllPerson;
        this.saveOnePerson = saveOnePerson;
        this.getListPersonByName = getListPersonByName;
        this.getOnePersonById = getOnePersonById;
        this.updateOnePerson = updateOnePerson;
        this.getYearOfBirth = getYearOfBirth;
        this.deleteOnePerson = deleteOnePerson;
    }

    @GetMapping
    public ResponseEntity<DataListResponse> getAll() {
        return ResponseEntity.ok(new DataListResponse(this.getAllPerson.execute(), 200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataObjectResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(new DataObjectResponse(this.getOnePersonById.execute(id), 200));
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.ok(this.saveOnePerson.execute(person));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DataListResponse> getListByName(@PathVariable String name) {
        return ResponseEntity.ok(new DataListResponse(this.getListPersonByName.execute(name), 200));
    }

    @GetMapping("/ageof/{id}")
    public ResponseEntity<DataAgeResponse> getYearBirth(@PathVariable Long id) {
        return ResponseEntity.ok(new DataAgeResponse(this.getYearOfBirth.execute(id), 200));
    }

    @PutMapping
    public ResponseEntity<DataObjectResponse> update(@RequestBody Person person) {
        return ResponseEntity.ok(new DataObjectResponse(this.updateOnePerson.execute(person), 200));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.deleteOnePerson.execute(id);
    }
}
