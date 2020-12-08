package com.interview.itv.pyoservice.exception;

import com.interview.itv.pyoservice.utils.Constants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    LocalDateTime now = LocalDateTime.now();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        ExceptionMessage exceptionMessage = ExceptionMessage.builder()
                .timestamp(now.format(DateTimeFormatter.ofPattern(Constants.ERROR_DATE_PATTERN)))
                .httpStatus(status)
                .httpCode(status.value())
                .details(ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(x -> x.getDefaultMessage())
                        .collect(Collectors.toList()))
                .build();

        return new ResponseEntity<>(exceptionMessage, headers, status);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionMessage> handleNotFoundException(NotFoundException exception, HttpServletRequest request) {
        ExceptionMessage exceptionMessage = ExceptionMessage.builder()
                .timestamp(now.format(DateTimeFormatter.ofPattern(Constants.ERROR_DATE_PATTERN)))
                .details(Arrays.asList(exception.getMessage()))
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PyoExistsException.class)
    public ResponseEntity<ExceptionMessage> handleServerErrorException(PyoExistsException exception, HttpServletRequest request) {
        ExceptionMessage exceptionMessage = ExceptionMessage.builder()
                .timestamp(now.format(DateTimeFormatter.ofPattern(Constants.ERROR_DATE_PATTERN)))
                .details(Arrays.asList(exception.getMessage()))
                .httpStatus(HttpStatus.CONFLICT)
                .build();
        return new ResponseEntity<>(exceptionMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InternalServiceErrorException.class)
    public ResponseEntity<ExceptionMessage> handleServerErrorException(InternalServiceErrorException exception, HttpServletRequest request) {
        ExceptionMessage exceptionMessage = ExceptionMessage.builder()
                .timestamp(now.format(DateTimeFormatter.ofPattern(Constants.ERROR_DATE_PATTERN)))
                .details(Arrays.asList(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()))
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
