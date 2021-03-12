package com.innowise.router.controllers;


import com.innowise.router.exceptions.InvalidFileException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(value = {InvalidFileException.class, IOException.class})
    public ResponseStatusException handle(InvalidFileException exception) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
    }
}
