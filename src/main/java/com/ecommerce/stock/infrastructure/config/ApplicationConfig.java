package com.ecommerce.stock.infrastructure.config;

import com.ecommerce.stock.domain.ports.api.CategoryIn;
import com.ecommerce.stock.domain.ports.spi.CategoryOut;
import com.ecommerce.stock.domain.service.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableJpaRepositories(basePackages = "com.microservicio.stock.infraestructure.jpaout.repositories")
public class ApplicationConfig {

    @Bean
    public CategoryIn categoryIn(CategoryOut categoryOut){
        return new CategoryService(categoryOut);
    }

}
