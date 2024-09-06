package com.ecommerce.stock.application.mapper;


import com.ecommerce.stock.application.dto.CategoryDTO;
import com.ecommerce.stock.domain.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO categoryDTO);
    CategoryDTO toDTO (Category category);
}
