package com.example.demo.exception.advice;

import com.example.demo.exception.ExceptionResponse;
import com.example.demo.exception.SillyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SillyException.class)
    public ResponseEntity<Object> handleExceptions(SillyException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setCode(exception.getCode());
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, exception.getStatus());
    }
}