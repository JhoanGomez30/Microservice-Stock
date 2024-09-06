package com.ecommerce.stock.infrastructure.jpaout.repositories.category;

import com.ecommerce.stock.domain.models.Category;
import com.ecommerce.stock.domain.ports.spi.ICategoryOut;
import com.ecommerce.stock.infrastructure.jpaout.entities.CategoryEntity;
import com.ecommerce.stock.infrastructure.jpaout.mapper.JpaCategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CategoryJpaOut implements ICategoryOut {

    private final ICategoryRepository ICategoryRepository;
    private final JpaCategoryMapper jpaCategoryMapper;

    @Override
    public boolean existByName(String name) {
        return ICategoryRepository.existsByName(name);
    }

    @Override
    public Category save(Category category) {

        CategoryEntity entity = jpaCategoryMapper.toEntity(category);
        CategoryEntity savedEntity = ICategoryRepository.save(entity);

        return jpaCategoryMapper.toDomain(savedEntity);
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> entities = ICategoryRepository.findAll();
        return entities.stream()
                .map(jpaCategoryMapper::toDomain)
                .collect(Collectors.toList());
    }
}
