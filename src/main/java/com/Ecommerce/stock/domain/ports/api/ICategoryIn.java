package com.ecommerce.stock.domain.ports.api;

import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.util.pagination.PageCustom;
import com.ecommerce.stock.domain.util.pagination.PageRequestCustom;

public interface ICategoryIn {

    Category createCategory(String name, String description);
    PageCustom<Category> listCategory(PageRequestCustom pageRequestCustom);

}
