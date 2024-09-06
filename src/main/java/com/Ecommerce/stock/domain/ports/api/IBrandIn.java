package com.ecommerce.stock.domain.ports.api;

import com.ecommerce.stock.domain.models.Brand;

public interface IBrandIn {

    Brand createBrand(String name, String description);
}
