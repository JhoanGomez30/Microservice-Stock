package com.ecommerce.stock.infrastructure.controllers;

import com.ecommerce.stock.application.dto.BrandDTO;
import com.ecommerce.stock.application.handler.BrandHandler;
import com.ecommerce.stock.infrastructure.jpaout.repositories.brand.BrandJpaOut;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController {

    private final BrandJpaOut brandJpaOut;
    private final BrandHandler brandHandler;

    @PostMapping
    public ResponseEntity<BrandDTO> saveBrand (@RequestBody BrandDTO brandDTO){

        BrandDTO newBrand = brandHandler.createBrand(brandDTO);
        return new ResponseEntity<>(newBrand, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<BrandDTO>> listBrands(Pageable pageable) {
        // Llamar al handler para obtener la lista paginada y ordenada de marcas en forma de DTO
        Page<BrandDTO> brands = brandHandler.listBrands(pageable);
        return ResponseEntity.ok(brands);
    }
}
