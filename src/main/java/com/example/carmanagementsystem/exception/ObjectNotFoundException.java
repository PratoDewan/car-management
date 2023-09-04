package com.example.carmanagementsystem.exception;

public class ObjectNotFoundException extends Exception{
    private static final String MESSAGE = "Error! There is no ";

    public ObjectNotFoundException(String obj) {
        super(MESSAGE+obj+" found!");
    }
}
