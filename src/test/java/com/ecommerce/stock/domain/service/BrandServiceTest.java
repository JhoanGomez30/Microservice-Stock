package com.ecommerce.stock.domain.service;

import com.ecommerce.stock.domain.exception.InvalidNameException;
import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.domain.ports.spi.IBrandOut;
import com.ecommerce.stock.domain.util.pagination.PageCustom;
import com.ecommerce.stock.domain.util.pagination.PageRequestCustom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BrandServiceTest {

    @Mock
    private IBrandOut brandOut;

    @InjectMocks
    private BrandService brandService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCategory_Successful() {
        String name = "Logitech";
        String description = "Enterprise of technology";

        when(brandOut.existsByName(name)).thenReturn(false);
        when(brandOut.save(any(Brand.class))).thenReturn(new Brand(1L, name, description));

        Brand result = brandService.createBrand(name, description);

        assertNotNull(result);
        assertEquals(name, result.getName());
        assertEquals(description, result.getDescription());
    }

    @Test
    void testCreateCategory_NameAlreadyExists() {
        String name = "Logitech";
        String description = "Enterprise of technology";

        when(brandOut.existsByName(name)).thenReturn(true);

        InvalidNameException exception = assertThrows(InvalidNameException.class, () -> {
            brandService.createBrand(name, description);
        });

        assertEquals("Brand already exist", exception.getMessage());
    }

    @Test
    void testListBrand_Success() {
        List<Brand> brands = List.of(new Brand(1L, "Books", "All kinds of books"), new Brand(2L, "Electronics", "All electronic items"));
        when(brandOut.findAll()).thenReturn(brands);

        PageRequestCustom pageRequestCustom = new PageRequestCustom(0, 10, true);
        PageCustom<Brand> result = brandService.listBrand(pageRequestCustom);

        assertNotNull(result);
        assertEquals(2, result.getTotalElements());
        assertEquals(1, result.getTotalPages());
    }

    @Test
    void testListBrand_Empty() {
        when(brandOut.findAll()).thenReturn(Collections.emptyList());

        PageRequestCustom pageRequestCustom = new PageRequestCustom(0, 10, true);
        PageCustom<Brand> result = brandService.listBrand(pageRequestCustom);

        assertNotNull(result);
        assertEquals(0, result.getTotalElements());
        assertEquals(0, result.getTotalPages());
    }
}