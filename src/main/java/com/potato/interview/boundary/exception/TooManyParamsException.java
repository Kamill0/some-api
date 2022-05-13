package com.potato.interview.boundary.exception;

public class TooManyParamsException extends RuntimeException {
    public TooManyParamsException(String message) {
        super(message);
    }
}
