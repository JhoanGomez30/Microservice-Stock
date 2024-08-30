package com.ecommerce.emazon.domain.service;

import com.ecommerce.emazon.domain.exception.InvalidNameCategoryException;
import com.ecommerce.emazon.domain.models.Category;
import com.ecommerce.emazon.domain.ports.spi.CategoryOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    private CategoryOut categoryOut;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCategory() {
        String nombre = "Video games";
        String descripcion = "All video games for your fun";

        when(categoryOut.existByName(nombre)).thenReturn(false);
        when(categoryOut.save(any(Category.class))).thenReturn(new Category(1L, nombre, descripcion));

        Category result = categoryService.createCategory(nombre, descripcion);

        assertNotNull(result);
        assertEquals(nombre, result.getName());
        assertEquals(descripcion, result.getDescription());
    }

    @Test
    void testCreateCategory_NameAlreadyExists() {
        String nombre = "Electronics";
        String descripcion = "All electronic items";

        when(categoryOut.existByName(nombre)).thenReturn(true);

        InvalidNameCategoryException exception = assertThrows(InvalidNameCategoryException.class, () -> {
            categoryService.createCategory(nombre, descripcion);
        });

        assertEquals("Category already exist", exception.getMessage());
    }
}