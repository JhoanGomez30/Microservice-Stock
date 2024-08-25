package com.Ecommerce.Emazon.application.handler;

import com.Ecommerce.Emazon.application.dto.CategoryDTO;
import com.Ecommerce.Emazon.application.mapper.CategoryMapper;
import com.Ecommerce.Emazon.domain.models.Category;
import com.Ecommerce.Emazon.domain.ports.api.CategoryIn;
import com.Ecommerce.Emazon.domain.util.Pageable.PageCustom;
import com.Ecommerce.Emazon.domain.util.Pageable.PageRequestCustom;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public PageCustom<CategoryDTO> listCategories(PageRequestCustom pageRequestCustom) {
        PageCustom<Category> categoryPage = categoryIn.listCategory(pageRequestCustom);
        List<CategoryDTO> dtoList = categoryPage.getContent().stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
        return new PageCustom<>(dtoList, categoryPage.getTotalElements(), categoryPage.getTotalPages(), categoryPage.getCurrentPage(),categoryPage.isAscending());
    }
}
