package com.Ecommerce.Emazon.domain.service;

import com.Ecommerce.Emazon.domain.exception.InvalidNameCategoryException;
import com.Ecommerce.Emazon.domain.ports.api.CategoryIn;
import com.Ecommerce.Emazon.domain.models.Category;
import com.Ecommerce.Emazon.domain.ports.spi.CategoryOut;
import com.Ecommerce.Emazon.domain.util.Pageable.PageCustom;
import com.Ecommerce.Emazon.domain.util.Pageable.PageRequestCustom;
import com.Ecommerce.Emazon.domain.util.ValidateCategory;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService implements CategoryIn {

    private final CategoryOut categoryOut;

    public CategoryService(CategoryOut categoryOut) {
        this.categoryOut = categoryOut;
    }

    @Override
    public Category createCategory(String name, String description) {
        ValidateCategory.validateName(name);
        ValidateCategory.validateDescription(description);

        if (categoryOut.existByName(name)) {
            String categoryExist = "Category already exist";
            throw new InvalidNameCategoryException(categoryExist);
        }

        Category category = new Category(null, name, description);
        return categoryOut.save(category);
    }

    @Override
    public PageCustom<Category> listCategory(PageRequestCustom pageRequestCustom) {
        List<Category> allCategories = categoryOut.findAll();

        // Ordenar las categorías
        List<Category> sortedCategories = allCategories.stream()
                .sorted((c1, c2) -> {
                    int comparison = c1.getName().compareToIgnoreCase(c2.getName());
                    return pageRequestCustom.isAscending() ? comparison : -comparison;
                })
                .collect(Collectors.toList());

        // Calcular inicio y final para la sublista de la página actual
        int start = pageRequestCustom.getPage() * pageRequestCustom.getSize();
        int end = Math.min(start + pageRequestCustom.getSize(), sortedCategories.size());

        // Crear la sublista para la página actual
        List<Category> paginatedCategories = sortedCategories.subList(start, end);

        // Calcular el número total de páginas
        int totalElements = sortedCategories.size();
        int totalPages = totalElements == 0 ? 0 : (int) Math.ceil((double) totalElements / pageRequestCustom.getSize());

        // Devolver el objeto PageCustom con las categorías paginadas y la información adicional
        return new PageCustom<>(paginatedCategories, totalElements, totalPages, pageRequestCustom.getPage(), pageRequestCustom.isAscending());
    }
}
