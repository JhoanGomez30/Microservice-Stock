package com.ecommerce.stock.infrastructure.exception;

public class NotFoundCategory extends RuntimeException{

    public NotFoundCategory(String message){
        super(message);
    }
}
