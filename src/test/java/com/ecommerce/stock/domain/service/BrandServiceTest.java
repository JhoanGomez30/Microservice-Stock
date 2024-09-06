package com.ecommerce.stock.domain.service;

import com.ecommerce.stock.domain.exception.InvalidNameException;
import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.spi.IBrandOut;
import com.ecommerce.stock.domain.ports.spi.ICategoryOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

        when(brandOut.existByName(name)).thenReturn(false);
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

        when(brandOut.existByName(name)).thenReturn(true);

        InvalidNameException exception = assertThrows(InvalidNameException.class, () -> {
            brandService.createBrand(name, description);
        });

        assertEquals("Brand already exist", exception.getMessage());
    }
}