package com.innowise.router.exceptions;

public class InvalidFileException extends RuntimeException {

    @Override
    public String getMessage() {
        return "File is not valid";
    }
}
