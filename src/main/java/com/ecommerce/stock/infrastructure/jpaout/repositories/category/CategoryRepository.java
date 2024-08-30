package com.ecommerce.stock.infrastructure.jpaout.repositories.category;

import com.ecommerce.stock.infrastructure.jpaout.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository <CategoryEntity, Long> {
    boolean existsByName(String name);
}

