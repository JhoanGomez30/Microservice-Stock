package com.ecommerce.emazon.domain.util;

import com.ecommerce.emazon.domain.exception.InvalidDescriptionCategoryException;
import com.ecommerce.emazon.domain.exception.InvalidNameCategoryException;

public class ValidateCategory {

    public static final String INVALID_NAME = "The Category name cannot be empty and/or exceed 50 characters.";
    private static final Integer MAX_LENGTH_NAME_CATEGORY = 50;
    private static final Integer MIN_LENGTH_NAME_CATEGORY = 3;
    private static final String INVALID_DESCRIPTION = "The description cannot be empty and/or exceed 90 characters";
    private static final Integer MAX_LENGTH_DESCRIPTION_CATEGORY = 90;
    private static final Integer MIN_LENGTH_DESCRIPTION_CATEGORY = 5;


    public static void validateName(String name){
        if(name.length() > MAX_LENGTH_NAME_CATEGORY || name.length()< MIN_LENGTH_NAME_CATEGORY){
            throw new InvalidNameCategoryException(INVALID_NAME);
        }
    }

    public static void validateDescription(String description){
        if(description.length() > MAX_LENGTH_DESCRIPTION_CATEGORY ||description.length() < MIN_LENGTH_DESCRIPTION_CATEGORY){
            throw new InvalidDescriptionCategoryException(INVALID_DESCRIPTION);
        }
    }
}
