package com.example.demos.exceptions;

public class NoUserFoundException extends Exception{
    public NoUserFoundException(String errorString){
        super(errorString);
    }
}