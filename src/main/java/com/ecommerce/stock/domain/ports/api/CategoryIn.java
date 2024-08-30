package com.ecommerce.stock.domain.ports.api;

import com.ecommerce.stock.domain.models.Category;

public interface CategoryIn {

    Category createCategory(String name, String description);
}
