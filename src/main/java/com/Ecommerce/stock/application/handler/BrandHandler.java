package com.ecommerce.stock.application.handler;

import com.ecommerce.stock.application.dto.BrandDTO;
import com.ecommerce.stock.application.mapper.BrandMapper;
import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.domain.ports.api.IBrandIn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandHandler {

    private final IBrandIn brandIn;
    private final BrandMapper brandMapper;

    public BrandDTO createBrand (BrandDTO brandDTO){
        Brand brand = brandMapper.toEntity(brandDTO);

        Brand newBrand = brandIn.createBrand(brand.getName(), brand.getDescription());
        return brandMapper.toDTO(newBrand);
    }
}
