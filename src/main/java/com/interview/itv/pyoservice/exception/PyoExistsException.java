package com.interview.itv.pyoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PyoExistsException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public PyoExistsException(String message) {
        super(message);
    }
}
