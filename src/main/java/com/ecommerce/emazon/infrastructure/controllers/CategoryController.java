package com.ecommerce.emazon.infrastructure.controllers;

import com.ecommerce.emazon.application.dto.CategoryDTO;
import com.ecommerce.emazon.application.handler.CategoryHandler;
import com.ecommerce.emazon.infrastructure.jpaout.repositories.category.CategoryJpaOut;
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
