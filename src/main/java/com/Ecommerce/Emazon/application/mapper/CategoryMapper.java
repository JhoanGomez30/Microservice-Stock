package com.Ecommerce.Emazon.application.mapper;


import com.Ecommerce.Emazon.application.dto.CategoryDTO;
import com.Ecommerce.Emazon.domain.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//,unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    Category toEntity(CategoryDTO categoryDTO);
    CategoryDTO toDTO (Category category);
}
