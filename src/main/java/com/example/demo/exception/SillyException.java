package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SillyException extends RuntimeException {
    public static final String SUPERSILLY_NOT_FOUND_CODE = "SILE001";
    public static final String SUPERSILLY_NOT_FOUND_DESC = "Supersilly not found";
    public static final String SILLY_NOT_FOUND_CODE = "SILE002";
    public static final String SILLY_NOT_FOUND_DESC = "Silly not found";

    private final String code;
    private final HttpStatus status;

    public SillyException(String message, String code, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public static SillyException getSillyNotFoundException() {
        return new SillyException(SILLY_NOT_FOUND_DESC, SILLY_NOT_FOUND_CODE, HttpStatus.NOT_FOUND);
    }

    public static SillyException getSupersillyNotFoundException() {
        return new SillyException(SUPERSILLY_NOT_FOUND_DESC, SUPERSILLY_NOT_FOUND_CODE, HttpStatus.NOT_FOUND);
    }
}
