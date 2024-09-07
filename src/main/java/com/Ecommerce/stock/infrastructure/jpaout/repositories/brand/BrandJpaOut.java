package com.ecommerce.stock.infrastructure.jpaout.repositories.brand;

import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.domain.ports.spi.IBrandOut;
import com.ecommerce.stock.infrastructure.jpaout.entities.BrandEntity;
import com.ecommerce.stock.infrastructure.jpaout.mapper.JpaBrandMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BrandJpaOut implements IBrandOut {

    private final IBrandRepository brandRepository;
    private final JpaBrandMapper jpaBrandMapper;


    @Override
    public boolean existsByName(String name) {
        return brandRepository.existsByName(name);
    }

    @Override
    public Brand save(Brand brand) {

        BrandEntity brandEntity = jpaBrandMapper.toEntity(brand);
        BrandEntity savedEntity = brandRepository.save(brandEntity);

        return jpaBrandMapper.toDomain(savedEntity);
    }

    @Override
    public List<Brand> findAll() {
        List<BrandEntity> entities = brandRepository.findAll();
        return entities.stream()
                .map(jpaBrandMapper::toDomain)
                .toList();
    }
}
