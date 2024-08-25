package com.Ecommerce.Emazon.domain.ports.spi;

import com.Ecommerce.Emazon.domain.models.Category;

public interface CategoryOut {

    boolean existByName(String name);
    Category save(Category category);
}
