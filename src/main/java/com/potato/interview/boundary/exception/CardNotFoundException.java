package com.potato.interview.boundary.exception;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(String reason) {
        super("Card not found for: " + reason);
    }
}
