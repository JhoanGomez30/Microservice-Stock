package com.Ecommerce.Emazon.infrastructure.jpaout.repositories.Category;

import com.Ecommerce.Emazon.domain.models.Category;
import com.Ecommerce.Emazon.domain.ports.spi.CategoryOut;
import com.Ecommerce.Emazon.infrastructure.jpaout.entities.CategoryEntity;
import com.Ecommerce.Emazon.infrastructure.jpaout.mapper.JpaCategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CategoryJpaOut implements CategoryOut {

    private final CategoryRepository categoryRepository;
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
                .collect(Collectors.toList());
    }
}
