package com.ecommerce.emazon.application.handler;

import com.ecommerce.emazon.application.dto.CategoryDTO;
import com.ecommerce.emazon.application.mapper.CategoryMapper;
import com.ecommerce.emazon.domain.models.Category;
import com.ecommerce.emazon.domain.ports.api.CategoryIn;
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
