package com.igrus.ootw.apipayload.exceptions.validation;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) {
        super(message);
    }
}
