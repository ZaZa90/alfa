package com.example.demo.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    private String message;
    private String code;
    private LocalDateTime dateTime;

}
