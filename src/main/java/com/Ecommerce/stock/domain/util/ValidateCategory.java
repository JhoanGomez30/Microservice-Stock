package com.ecommerce.stock.domain.util;

import com.ecommerce.stock.domain.exception.InvalidDescriptionException;
import com.ecommerce.stock.domain.exception.InvalidNameException;

public class ValidateCategory {

    public static final String INVALID_NAME_CATEGORY = "Category name cannot be empty, have less than 3 characters or exceed 50 characters.";
    private static final Integer MAX_LENGTH_NAME_CATEGORY = 50;
    private static final Integer MIN_LENGTH_NAME_CATEGORY = 3;

    private static final String INVALID_DESCRIPTION_CATEGORY = "The category description cannot be empty, have less than 5 characters or exceed 90 characters";
    private static final Integer MAX_LENGTH_DESCRIPTION_CATEGORY = 90;
    private static final Integer MIN_LENGTH_DESCRIPTION_CATEGORY = 5;


    public static void validateNameCategory(String name){
        if(name.length() > MAX_LENGTH_NAME_CATEGORY || name.length()< MIN_LENGTH_NAME_CATEGORY){
            throw new InvalidNameException(INVALID_NAME_CATEGORY);
        }
    }

    public static void validateDescriptionCategory(String description){
        if(description.length() > MAX_LENGTH_DESCRIPTION_CATEGORY ||description.length() < MIN_LENGTH_DESCRIPTION_CATEGORY){
            throw new InvalidDescriptionException(INVALID_DESCRIPTION_CATEGORY);
        }
    }
}
