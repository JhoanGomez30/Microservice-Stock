package com.ecommerce.emazon.infrastructure.exception;

public class NotFoundCategory extends RuntimeException{

    public NotFoundCategory(String message){
        super(message);
    }
}
