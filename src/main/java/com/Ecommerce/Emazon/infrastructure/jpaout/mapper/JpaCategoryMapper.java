package com.Ecommerce.Emazon.infrastructure.jpaout.mapper;

import com.Ecommerce.Emazon.domain.models.Category;
import com.Ecommerce.Emazon.infrastructure.jpaout.entities.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//,unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface JpaCategoryMapper {

    CategoryEntity toEntity (Category category);
    Category toDomain (CategoryEntity categoryEntity);
}
