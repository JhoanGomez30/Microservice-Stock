package com.Ecommerce.Emazon.application.handler;

import com.Ecommerce.Emazon.application.dto.CategoryDTO;
import com.Ecommerce.Emazon.application.mapper.CategoryMapper;
import com.Ecommerce.Emazon.domain.models.Category;
import com.Ecommerce.Emazon.domain.ports.api.CategoryIn;
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
