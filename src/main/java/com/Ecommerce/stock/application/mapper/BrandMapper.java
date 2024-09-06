package com.ecommerce.stock.application.mapper;

import com.ecommerce.stock.application.dto.BrandDTO;
import com.ecommerce.stock.domain.models.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand toEntity (BrandDTO brandDTO);
    BrandDTO toDTO (Brand brand);
}
