package com.example.demos.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED,reason = "User is not authorized to call this method")
public class WrongAuthLevelException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 5472824081538159364L;

    public WrongAuthLevelException(String message, Throwable err) {
        super(message,err);
    }
}