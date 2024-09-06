package com.ecommerce.stock.domain.service;

import com.ecommerce.stock.domain.exception.InvalidNameException;
import com.ecommerce.stock.domain.ports.api.ICategoryIn;
import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.spi.ICategoryOut;
import com.ecommerce.stock.domain.util.Pageable.PageCustom;
import com.ecommerce.stock.domain.util.Pageable.PageRequestCustom;
import com.ecommerce.stock.domain.util.ValidateCategory;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService implements ICategoryIn {

    private final ICategoryOut categoryOut;

    public CategoryService(ICategoryOut categoryOut) {
        this.categoryOut = categoryOut;
    }

    @Override
    public Category createCategory(String name, String description) {
        ValidateCategory.validateNameCategory(name);
        ValidateCategory.validateDescriptionCategory(description);

        if (categoryOut.existByName(name)) {
            String categoryExist = "Category already exist";
            throw new InvalidNameException(categoryExist);
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
