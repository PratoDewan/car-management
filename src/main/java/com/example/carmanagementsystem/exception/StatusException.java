package com.example.carmanagementsystem.exception;

public class StatusException extends Exception{
    private static final String MESSAGE = "Error! Car is not available!";

    public StatusException() {
        super(MESSAGE);
    }
}
