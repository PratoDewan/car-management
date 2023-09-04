package com.example.carmanagementsystem.exception;

public class InvalidQueryException extends Exception{
    private static final String MESSAGE = "Error! Invalid Query, ID can not be negative!";

    public InvalidQueryException() {
        super(MESSAGE);
    }
}
