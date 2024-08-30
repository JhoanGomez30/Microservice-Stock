package com.ecommerce.stock.domain.ports.spi;

import com.ecommerce.stock.domain.models.Category;

import java.util.List;

public interface CategoryOut {

    boolean existByName(String name);
    Category save(Category category);
    List<Category> findAll();
}
