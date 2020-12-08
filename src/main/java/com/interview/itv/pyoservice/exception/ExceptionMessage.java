package com.interview.itv.pyoservice.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Data
public class ExceptionMessage {
    private String timestamp;
    private List<String> details;
    private HttpStatus httpStatus;
    private int httpCode;
}