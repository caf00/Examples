package com.alejandro.crud.simplearraycrud.exception;

public class PersonAlreadyExistException extends RuntimeException{
    public PersonAlreadyExistException(String message) {
        super(message);
    }
}
