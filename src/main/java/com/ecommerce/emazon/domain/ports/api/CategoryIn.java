package com.ecommerce.emazon.domain.ports.api;

import com.ecommerce.emazon.domain.models.Category;

public interface CategoryIn {

    Category createCategory(String name, String description);
}
