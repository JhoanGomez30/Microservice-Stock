package com.ecommerce.stock.domain.exception;

public class InvalidDescriptionCategoryException extends RuntimeException{

    public InvalidDescriptionCategoryException(String message) {
        super(message);
    }
}
