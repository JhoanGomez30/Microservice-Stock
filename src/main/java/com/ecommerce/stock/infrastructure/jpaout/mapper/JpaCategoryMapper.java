package com.ecommerce.stock.infrastructure.jpaout.mapper;

import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.infrastructure.jpaout.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JpaCategoryMapper {

    CategoryEntity toEntity (Category category);
    Category toDomain (CategoryEntity categoryEntity);
}
