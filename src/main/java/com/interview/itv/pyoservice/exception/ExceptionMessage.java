package com.interview.itv.pyoservice.exception;

import lombok.Builder;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Setter
public class ExceptionMessage {
    private String timestamp;
    private List<String> details;
    private HttpStatus httpStatus;
    private int httpCode;
}