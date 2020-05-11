package com.example.demos.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Json Format Incorrect")
public class WrongJsonFormatException extends Exception{

	/**
	 *
	 */
    private static final long serialVersionUID = 1L;
    
    public WrongJsonFormatException(String error){
        super(error);
    }
    
}