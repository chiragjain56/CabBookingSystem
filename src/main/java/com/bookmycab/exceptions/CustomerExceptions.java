package com.bookmycab.exceptions;


import com.bookmycab.model.User;

public class CustomerExceptions extends UserException {
    public CustomerExceptions() {
    }

    public CustomerExceptions(String message) {
        super(message);
    }
}
