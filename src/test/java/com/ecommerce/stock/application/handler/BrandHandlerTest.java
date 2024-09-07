package com.ecommerce.stock.application.handler;

import com.ecommerce.stock.application.dto.BrandDTO;
import com.ecommerce.stock.application.mapper.BrandMapper;
import com.ecommerce.stock.application.mapper.PageMapper;
import com.ecommerce.stock.domain.models.Brand;
import com.ecommerce.stock.domain.ports.api.IBrandIn;
import com.ecommerce.stock.domain.util.pagination.PageCustom;
import com.ecommerce.stock.domain.util.pagination.PageRequestCustom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BrandHandlerTest {

    @Mock
    private IBrandIn brandIn;

    @Mock
    private BrandMapper brandMapper;

    @InjectMocks
    private BrandHandler brandHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListBrand_Success() {
        Brand brand = new Brand(1L, "Books", "All kinds of books");
        BrandDTO brandDTO = new BrandDTO(1L, "Books", "All kinds of books");

        when(brandIn.listBrand(any(PageRequestCustom.class))).thenReturn(new PageCustom<>(List.of(brand), 1, 1, 0, true));
        when(brandMapper.toDTO(any(Brand.class))).thenReturn(brandDTO);

        Pageable pageable = PageMapper.toSpringPageable(new PageRequestCustom(0, 10, true));
        Page<BrandDTO> result = brandHandler.listBrands(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(brandDTO, result.getContent().get(0));
    }

}