package com.Ecommerce.Emazon.domain.service;

import com.Ecommerce.Emazon.domain.exception.InvalidNameCategoryException;
import com.Ecommerce.Emazon.domain.ports.api.CategoryIn;
import com.Ecommerce.Emazon.domain.models.Category;
import com.Ecommerce.Emazon.domain.ports.spi.CategoryOut;
import com.Ecommerce.Emazon.domain.util.ValidateCategory;

public class CategoryService implements CategoryIn {

    private final CategoryOut categoryOut;

    public CategoryService(CategoryOut categoryOut) {
        this.categoryOut = categoryOut;
    }

    @Override
    public Category createCategory(String name, String description) {
        ValidateCategory.validateName(name);
        ValidateCategory.validateDescription(description);

        if (categoryOut.existByName(name)) {
            String categoryExist = "Category already exist";
            throw new InvalidNameCategoryException(categoryExist);
        }

        Category category = new Category(null, name, description);
        return categoryOut.save(category);
    }
}
