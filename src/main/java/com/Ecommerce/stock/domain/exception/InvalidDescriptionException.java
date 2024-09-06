package com.ecommerce.stock.domain.exception;

public class InvalidDescriptionException extends RuntimeException{

    public InvalidDescriptionException(String message) {
        super(message);
    }
}
