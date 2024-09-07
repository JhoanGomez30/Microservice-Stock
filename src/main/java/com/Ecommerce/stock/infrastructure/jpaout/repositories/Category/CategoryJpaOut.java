package com.ecommerce.stock.infrastructure.jpaout.repositories.category;

import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.spi.ICategoryOut;
import com.ecommerce.stock.infrastructure.jpaout.entities.CategoryEntity;
import com.ecommerce.stock.infrastructure.jpaout.mapper.JpaCategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CategoryJpaOut implements ICategoryOut {

    private final ICategoryRepository categoryRepository;
    private final JpaCategoryMapper jpaCategoryMapper;

    @Override
    public boolean existByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public Category save(Category category) {

        CategoryEntity entity = jpaCategoryMapper.toEntity(category);
        CategoryEntity savedEntity = categoryRepository.save(entity);

        return jpaCategoryMapper.toDomain(savedEntity);
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> entities = categoryRepository.findAll();
        return entities.stream()
                .map(jpaCategoryMapper::toDomain)
                .toList();
    }
}
