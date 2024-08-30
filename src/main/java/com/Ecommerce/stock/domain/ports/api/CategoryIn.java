package com.ecommerce.stock.domain.ports.api;

import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.util.Pageable.PageCustom;
import com.ecommerce.stock.domain.util.Pageable.PageRequestCustom;

public interface CategoryIn {

    Category createCategory(String name, String description);
    PageCustom<Category> listCategory(PageRequestCustom pageRequestCustom);
//    CategoryEntity getCategory (Long id);
//
//    void updateCategory(CategoryEntity category);
//
//    void deleteCategory(Long id);
}
