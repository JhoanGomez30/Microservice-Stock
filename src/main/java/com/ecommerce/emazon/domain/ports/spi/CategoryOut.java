package com.ecommerce.emazon.domain.ports.spi;

import com.ecommerce.emazon.domain.models.Category;

public interface CategoryOut {

    boolean existByName(String name);
    Category save(Category category);
}
