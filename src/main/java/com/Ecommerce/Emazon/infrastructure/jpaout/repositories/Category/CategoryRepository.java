package com.Ecommerce.Emazon.infrastructure.jpaout.repositories.Category;

import com.Ecommerce.Emazon.infrastructure.jpaout.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository <CategoryEntity, Long> {
    boolean existsByName(String name);
}

