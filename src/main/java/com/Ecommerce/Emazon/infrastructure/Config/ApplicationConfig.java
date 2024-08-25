package com.Ecommerce.Emazon.infrastructure.Config;

import com.Ecommerce.Emazon.domain.ports.api.CategoryIn;
import com.Ecommerce.Emazon.domain.ports.spi.CategoryOut;
import com.Ecommerce.Emazon.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@EnableJpaRepositories(basePackages = "com.microservicio.stock.infraestructure.jpaout.repositories")
public class ApplicationConfig {

    @Bean
    public CategoryIn categoryIn(CategoryOut categoryOut){
        return new CategoryService(categoryOut);
    }

}
