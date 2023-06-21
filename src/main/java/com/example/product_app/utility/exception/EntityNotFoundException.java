package com.example.product_app.utility.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
