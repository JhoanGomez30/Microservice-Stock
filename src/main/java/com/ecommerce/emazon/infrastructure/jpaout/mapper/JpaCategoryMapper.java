package com.ecommerce.emazon.infrastructure.jpaout.mapper;

import com.ecommerce.emazon.domain.models.Category;
import com.ecommerce.emazon.infrastructure.jpaout.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//,unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface JpaCategoryMapper {

    CategoryEntity toEntity (Category category);
    Category toDomain (CategoryEntity categoryEntity);
}
