package com.example.carmanagementsystem.controller;

import com.example.carmanagementsystem.exception.EmptyResultFoundException;
import com.example.carmanagementsystem.exception.InvalidQueryException;
import com.example.carmanagementsystem.exception.ObjectNotFoundException;
import com.example.carmanagementsystem.exception.StatusException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler({NoSuchFieldException.class})
    public ResponseEntity<?> handleFieldException() {
        return new ResponseEntity<>((new StatusException()).getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<?> handleIllegalArgumentException() {
        return new ResponseEntity<>((new InvalidQueryException()).getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<?> handleNoResultException(NoSuchElementException ex) {
        return new ResponseEntity<>((new ObjectNotFoundException(ex.getMessage())).getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<?> handleEmptyResultException() {
        return new ResponseEntity<>((new EmptyResultFoundException()).getMessage(), HttpStatus.NOT_FOUND);
    }
}
