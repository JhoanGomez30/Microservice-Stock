package com.ecommerce.emazon.infrastructure.config;

import com.ecommerce.emazon.domain.ports.api.CategoryIn;
import com.ecommerce.emazon.domain.ports.spi.CategoryOut;
import com.ecommerce.emazon.domain.service.CategoryService;
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
