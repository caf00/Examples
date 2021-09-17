package com.alejandro.crud.simplearraycrud.response;

import com.alejandro.crud.simplearraycrud.entity.Person;

import java.io.Serializable;

public class DataObjectResponse implements Serializable {
    private Person person;
    private int status;

    public DataObjectResponse(Person person, int status) {
        this.person = person;
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
