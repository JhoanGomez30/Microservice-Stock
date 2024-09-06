package com.ecommerce.stock.infrastructure.controllers;

import com.ecommerce.stock.application.dto.BrandDTO;
import com.ecommerce.stock.application.handler.BrandHandler;
import com.ecommerce.stock.infrastructure.jpaout.repositories.brand.BrandJpaOut;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
