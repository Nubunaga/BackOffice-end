package com.example.demos.exceptions;

public class NoOrderIdFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NoOrderIdFoundException(String error){
        super(error);
    }

    
}