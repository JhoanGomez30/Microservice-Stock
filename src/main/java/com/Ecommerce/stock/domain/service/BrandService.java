package com.ecommerce.stock.domain.service;

import com.ecommerce.stock.domain.exception.InvalidNameException;
import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.domain.ports.api.IBrandIn;
import com.ecommerce.stock.domain.ports.spi.IBrandOut;
import com.ecommerce.stock.domain.util.ValidateBrand;
import com.ecommerce.stock.domain.util.pagination.PageCustom;
import com.ecommerce.stock.domain.util.pagination.PageRequestCustom;
import com.ecommerce.stock.domain.util.pagination.PagingUtil;

import java.util.List;

public class BrandService implements IBrandIn {

    private final IBrandOut brandOut;

    public BrandService(IBrandOut brandOut) {
        this.brandOut = brandOut;
    }


    @Override
    public Brand createBrand(String name, String description) {
        ValidateBrand.validateNameBrand(name);
        ValidateBrand.validateDescriptionBrand(description);

        if (brandOut.existsByName(name)){
            String brandExist = "Brand already exist";
            throw new InvalidNameException(brandExist);
        }
        Brand brand = new Brand(null, name, description);
        return brandOut.save(brand);
    }

    @Override
    public PageCustom<Brand> listBrand(PageRequestCustom pageRequestCustom) {
        List<Brand> allBrands = brandOut.findAll();
        return PagingUtil.paginateAndSort(allBrands, pageRequestCustom, Brand::getName);
    }
}
