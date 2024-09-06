package com.ecommerce.stock.infrastructure.jpaout.mapper;

import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.infrastructure.jpaout.entities.BrandEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JpaBrandMapper {

    BrandEntity toEntity (Brand brand);
    Brand toDomain (BrandEntity brandEntity);

}
