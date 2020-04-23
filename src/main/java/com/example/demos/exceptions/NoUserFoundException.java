package com.example.demos.exceptions;

public class NoUserFoundException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NoUserFoundException(String errorString) {
        super(errorString);
    }
}