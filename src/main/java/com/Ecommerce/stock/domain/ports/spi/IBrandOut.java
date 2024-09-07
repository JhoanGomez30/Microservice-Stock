package com.ecommerce.stock.domain.ports.spi;

import com.ecommerce.stock.domain.models.Brand;

import java.util.List;

public interface IBrandOut {

    boolean existsByName(String name);
    Brand save(Brand brand);
    List<Brand> findAll();
}
