package com.ecommerce.stock.domain.ports.spi;

import com.ecommerce.stock.domain.models.Category;

public interface CategoryOut {

    boolean existByName(String name);
    Category save(Category category);
}
