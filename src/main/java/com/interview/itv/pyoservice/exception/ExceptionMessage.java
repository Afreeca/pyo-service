package com.interview.itv.pyoservice.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {
    private String timestamp;
    private List<String> details;
    private HttpStatus httpStatus;
    private int httpCode;
}