package com.ecommerce.emazon.application.mapper;


import com.ecommerce.emazon.application.dto.CategoryDTO;
import com.ecommerce.emazon.domain.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//,unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    Category toEntity(CategoryDTO categoryDTO);
    CategoryDTO toDTO (Category category);
}
