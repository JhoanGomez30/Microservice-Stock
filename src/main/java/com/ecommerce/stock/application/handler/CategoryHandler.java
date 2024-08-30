package com.ecommerce.stock.application.handler;

import com.ecommerce.stock.application.dto.CategoryDTO;
import com.ecommerce.stock.application.mapper.CategoryMapper;
import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.api.CategoryIn;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryHandler {
    private final CategoryIn categoryIn;
    private final CategoryMapper categoryMapper;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){

        Category category = categoryMapper.toEntity(categoryDTO);

        Category newCategory = categoryIn.createCategory(category.getName(), category.getDescription());
        return categoryMapper.toDTO(newCategory);
    }
}
