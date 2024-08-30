package com.ecommerce.stock.domain.service;

import com.ecommerce.stock.domain.exception.InvalidNameCategoryException;
import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.api.CategoryIn;
import com.ecommerce.stock.domain.ports.spi.CategoryOut;
import com.ecommerce.stock.domain.util.ValidateCategory;

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
