package com.ecommerce.stock.domain.service;

import com.ecommerce.stock.domain.exception.InvalidNameException;
import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.spi.ICategoryOut;
import com.ecommerce.stock.domain.util.Pageable.PageCustom;
import com.ecommerce.stock.domain.util.Pageable.PageRequestCustom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    private ICategoryOut ICategoryOut;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCategory_Successful() {
        String name = "Electronics";
        String description = "All electronic items";

        when(ICategoryOut.existByName(name)).thenReturn(false);
        when(ICategoryOut.save(any(Category.class))).thenReturn(new Category(1L, name, description));

        Category result = categoryService.createCategory(name, description);

        assertNotNull(result);
        assertEquals(name, result.getName());
        assertEquals(description, result.getDescription());
    }

    @Test
    void testCreateCategory_NameAlreadyExists() {
        String nombre = "Electronics";
        String descripcion = "All electronic items";

        when(ICategoryOut.existByName(nombre)).thenReturn(true);

        InvalidNameException exception = assertThrows(InvalidNameException.class, () -> {
            categoryService.createCategory(nombre, descripcion);
        });

        assertEquals("Category already exist", exception.getMessage());
    }

    @Test
    void testListCategory_AscendingOrder() {
        List<Category> categories = Arrays.asList(
                new Category(1L, "Electronics", "All electronic items"),
                new Category(2L, "Books", "Various kinds of books"),
                new Category(3L, "Furniture", "Home and office furniture")
        );

        when(ICategoryOut.findAll()).thenReturn(categories);

        PageRequestCustom pageRequest = new PageRequestCustom(0, 2, true); // Orden ascendente, página 0, tamaño 2
        PageCustom<Category> result = categoryService.listCategory(pageRequest);

        assertNotNull(result);
        assertEquals(2, result.getContent().size());
        assertEquals("Books", result.getContent().get(0).getName()); // Verifica que el orden sea ascendente
        assertEquals("Electronics", result.getContent().get(1).getName());
        assertEquals(2, result.getTotalPages());
        assertEquals(0, result.getCurrentPage());
        assertTrue(result.isAscending()); // Verifica que el orden sea ascendente
        assertFalse(result.isEmpty()); // Verifica que la página no esté vacía
    }

    @Test
    void testListCategory_EmptyPage() {
        when(ICategoryOut.findAll()).thenReturn(Collections.emptyList());

        PageRequestCustom pageRequest = new PageRequestCustom(0, 2, true);
        PageCustom<Category> result = categoryService.listCategory(pageRequest);

        assertNotNull(result);
        assertTrue(result.isEmpty()); // Verifica que la página esté vacía
        assertEquals(0, result.getTotalElements());
        assertEquals(0, result.getTotalPages()); //
        assertEquals(0, result.getCurrentPage());
        assertTrue(result.isAscending()); // Verifica que el orden sea ascendente
    }
}