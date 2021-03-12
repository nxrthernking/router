package com.innowise.router.exceptions;

public class InvalidFileException extends Exception {
    @Override
    public String getMessage() {
        return "File is not valid";
    }
}
