package com.test.test.exception;

public class NotFoundException extends Exception {
    private static final String NOT_FOUND_ERROR_MESSAGE = "User not found";

    public NotFoundException() {
        super(NOT_FOUND_ERROR_MESSAGE);
    }
}
