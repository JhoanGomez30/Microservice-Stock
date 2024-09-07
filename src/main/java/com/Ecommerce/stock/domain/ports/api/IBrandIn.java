package com.ecommerce.stock.domain.ports.api;

import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.domain.util.pagination.PageCustom;
import com.ecommerce.stock.domain.util.pagination.PageRequestCustom;

public interface IBrandIn {

    Brand createBrand(String name, String description);
    PageCustom<Brand> listBrand(PageRequestCustom pageRequestCustom);
}
