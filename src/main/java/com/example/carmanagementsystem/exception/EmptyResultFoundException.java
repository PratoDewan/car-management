package com.example.carmanagementsystem.exception;

public class EmptyResultFoundException extends Exception{
    private static final String MESSAGE = "Error! Result is empty!";

    public EmptyResultFoundException() {
        super(MESSAGE);
    }

}
