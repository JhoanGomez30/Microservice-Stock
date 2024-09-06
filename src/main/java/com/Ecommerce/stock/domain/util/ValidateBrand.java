package com.ecommerce.stock.domain.util;

import com.ecommerce.stock.domain.exception.InvalidDescriptionException;
import com.ecommerce.stock.domain.exception.InvalidNameException;

public class ValidateBrand {

    public static final String INVALID_NAME_BRAND = "The brand name cannot be empty, have less than 3 characters or exceed 50 characters.";
    private static final Integer MAX_LENGTH_NAME_BRAND = 50;
    private static final Integer MIN_LENGTH_NAME_BRAND = 3;
    private static final String INVALID_DESCRIPTION_BRAND = "The brand description cannot be empty, have less than 5 characters or exceed 120 characters.";
    private static final Integer MAX_LENGTH_DESCRIPTION_BRAND = 120;
    private static final Integer MIN_LENGTH_DESCRIPTION_BRAND = 5;


    public static void validateNameBrand(String name){
        if(name.length() > MAX_LENGTH_NAME_BRAND || name.length()< MIN_LENGTH_NAME_BRAND){
            throw new InvalidNameException(INVALID_NAME_BRAND);
        }
    }

    public static void validateDescriptionBrand(String description){
        if(description.length() > MAX_LENGTH_DESCRIPTION_BRAND ||description.length() < MIN_LENGTH_DESCRIPTION_BRAND){
            throw new InvalidDescriptionException(INVALID_DESCRIPTION_BRAND);
        }
    }
}
