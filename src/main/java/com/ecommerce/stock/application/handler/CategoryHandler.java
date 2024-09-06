package com.ecommerce.stock.application.handler;

import com.ecommerce.stock.application.dto.CategoryDTO;
import com.ecommerce.stock.application.mapper.CategoryMapper;
import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.api.ICategoryIn;
import com.ecommerce.stock.domain.util.Pageable.PageCustom;
import com.ecommerce.stock.domain.util.Pageable.PageRequestCustom;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryHandler {
    private final ICategoryIn categoryIn;
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
