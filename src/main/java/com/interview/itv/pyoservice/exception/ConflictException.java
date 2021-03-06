package com.interview.itv.pyoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends Exception {
    private static final long serialVersionUID = 1L;
    public ConflictException(String message) {
        super(message);
    }
}
