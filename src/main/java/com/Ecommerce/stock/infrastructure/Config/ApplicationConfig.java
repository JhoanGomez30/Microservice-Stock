package com.ecommerce.stock.infrastructure.config;

import com.ecommerce.stock.domain.ports.api.IBrandIn;
import com.ecommerce.stock.domain.ports.api.ICategoryIn;
import com.ecommerce.stock.domain.ports.spi.IBrandOut;
import com.ecommerce.stock.domain.ports.spi.ICategoryOut;
import com.ecommerce.stock.domain.service.BrandService;
import com.ecommerce.stock.domain.service.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ICategoryIn categoryIn (ICategoryOut categoryOut){
        return new CategoryService(categoryOut);
    }

    @Bean
    public IBrandIn brandIn (IBrandOut brandOut){
        return new BrandService(brandOut);
    }
}
