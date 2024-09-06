package com.ecommerce.stock.infrastructure.jpaout.repositories.brand;

import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.domain.ports.spi.IBrandOut;
import com.ecommerce.stock.infrastructure.jpaout.entities.BrandEntity;
import com.ecommerce.stock.infrastructure.jpaout.mapper.JpaBrandMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BrandJpaOut implements IBrandOut {

    private final IBrandRepository IBrandRepository;
    private final JpaBrandMapper jpaBrandMapper;


    @Override
    public boolean existsByName(String name) {
        return IBrandRepository.existsByName(name);
    }

    @Override
    public Brand save(Brand brand) {

        BrandEntity brandEntity = jpaBrandMapper.toEntity(brand);
        BrandEntity savedEntity = IBrandRepository.save(brandEntity);

        return jpaBrandMapper.toDomain(savedEntity);
    }
}
