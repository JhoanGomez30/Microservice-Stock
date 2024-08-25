package com.Ecommerce.Emazon.domain.ports.api;

import com.Ecommerce.Emazon.domain.models.Category;

public interface CategoryIn {

    Category createCategory(String name, String description);

//    CategoryEntity getCategory (Long id);
//
//    void updateCategory(CategoryEntity category);
//
//    void deleteCategory(Long id);
}
