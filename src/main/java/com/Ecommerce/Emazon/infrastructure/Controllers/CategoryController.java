package com.Ecommerce.Emazon.infrastructure.Controllers;

import com.Ecommerce.Emazon.application.dto.CategoryDTO;
import com.Ecommerce.Emazon.application.handler.CategoryHandler;
import com.Ecommerce.Emazon.infrastructure.jpaout.repositories.Category.CategoryJpaOut;
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

//    @GetMapping
//    public List<Category> findAll() {
//        return categoryJpaOut.findAll();
//    }
}
