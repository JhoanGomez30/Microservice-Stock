package com.ecommerce.stock.application.handler;

import com.ecommerce.stock.application.dto.CategoryDTO;
import com.ecommerce.stock.application.mapper.CategoryMapper;
import com.ecommerce.stock.application.mapper.PageMapper;
import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.api.ICategoryIn;
import com.ecommerce.stock.domain.util.pagination.PageCustom;
import com.ecommerce.stock.domain.util.pagination.PageRequestCustom;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<CategoryDTO> listCategories(Pageable pageable) {
        //parsear Pageable Spring a PageRequestCustom
        PageRequestCustom pageRequestCustom = new PageRequestCustom(pageable.getPageNumber(),pageable.getPageSize(),pageable.getSort().isSorted());
        //usar la interfaz de dominio
        PageCustom<Category> pageCustom = categoryIn.listCategory(pageRequestCustom);
        //convertir PageCustom a Page de Spring y mapearDTOS
        return PageMapper.toSpringPage(
                new PageCustom<>(
                        pageCustom.getContent().stream().map(categoryMapper::toDTO).toList(),
                        pageCustom.getTotalElements(),
                        pageCustom.getTotalPages(),
                        pageCustom.getCurrentPage(),
                        pageCustom.isAscending()
                )
        );
    }
}
