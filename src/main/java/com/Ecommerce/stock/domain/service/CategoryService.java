package com.ecommerce.stock.domain.service;

import com.ecommerce.stock.domain.exception.InvalidNameException;
import com.ecommerce.stock.domain.ports.api.ICategoryIn;
import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.spi.ICategoryOut;
import com.ecommerce.stock.domain.util.pagination.PageCustom;
import com.ecommerce.stock.domain.util.pagination.PageRequestCustom;
import com.ecommerce.stock.domain.util.ValidateCategory;
import com.ecommerce.stock.domain.util.pagination.PagingUtil;

import java.util.List;

public class CategoryService implements ICategoryIn {

    private final ICategoryOut categoryOut;

    public CategoryService(ICategoryOut categoryOut) {
        this.categoryOut = categoryOut;
    }

    @Override
    public Category createCategory(String name, String description) {
        ValidateCategory.validateNameCategory(name);
        ValidateCategory.validateDescriptionCategory(description);

        if (categoryOut.existByName(name)) {
            String categoryExist = "Category already exist";
            throw new InvalidNameException(categoryExist);
        }

        Category category = new Category(null, name, description);
        return categoryOut.save(category);
    }

    @Override
    public PageCustom<Category> listCategory(PageRequestCustom pageRequestCustom) {
        List<Category> allCategories = categoryOut.findAll();
        return PagingUtil.paginateAndSort(allCategories, pageRequestCustom, Category::getName);
    }
}
