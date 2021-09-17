package com.alejandro.crud.simplearraycrud.exception;

import com.alejandro.crud.simplearraycrud.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> personNotFound(PersonNotFoundException personNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(personNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(PersonAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> personAlreadyExist(PersonAlreadyExistException personAlreadyExistException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(personAlreadyExistException.getMessage(), HttpStatus.CONFLICT.value()));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> internalError(Exception exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
