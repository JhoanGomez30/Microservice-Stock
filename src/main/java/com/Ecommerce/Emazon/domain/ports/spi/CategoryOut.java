package com.Ecommerce.Emazon.domain.ports.spi;

import com.Ecommerce.Emazon.domain.models.Category;

import java.util.List;

public interface CategoryOut {

    boolean existByName(String name);
    Category save(Category category);
    List<Category> findAll();
}
