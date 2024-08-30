package com.ecommerce.stock.infrastructure.controllers;

import com.ecommerce.stock.application.dto.CategoryDTO;
import com.ecommerce.stock.application.handler.CategoryHandler;
import com.ecommerce.stock.infrastructure.jpaout.repositories.category.CategoryJpaOut;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryJpaOut categoryJpaOut;
    private final CategoryHandler categoryHandler;

    @PostMapping
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO newCategory = categoryHandler.createCategory(categoryDTO);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }
}
