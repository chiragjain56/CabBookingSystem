package com.bookmycab.exceptions;

public class TripException extends RuntimeException {
    public TripException() {
    }

    public TripException(String message) {
        super(message);
    }
}
