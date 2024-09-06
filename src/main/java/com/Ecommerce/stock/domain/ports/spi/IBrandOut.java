package com.ecommerce.stock.domain.ports.spi;

import com.ecommerce.stock.domain.models.Brand;

public interface IBrandOut {

    boolean existsByName(String name);
    Brand save(Brand brand);
}
