package com.Ecommerce.Emazon.domain.ports.api;

import com.Ecommerce.Emazon.domain.models.Category;
import com.Ecommerce.Emazon.domain.util.Pageable.PageCustom;
import com.Ecommerce.Emazon.domain.util.Pageable.PageRequestCustom;

public interface CategoryIn {

    Category createCategory(String name, String description);
    PageCustom<Category> listCategory(PageRequestCustom pageRequestCustom);
//    CategoryEntity getCategory (Long id);
//
//    void updateCategory(CategoryEntity category);
//
//    void deleteCategory(Long id);
}
