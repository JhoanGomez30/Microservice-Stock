package com.ecommerce.stock.infrastructure.jpaout.repositories.brand;

import com.ecommerce.stock.infrastructure.jpaout.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {

    boolean existsByName(String name);
}
