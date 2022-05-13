package com.potato.interview.boundary.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String reason) {
        super("User not found for: " + reason);
    }
}
