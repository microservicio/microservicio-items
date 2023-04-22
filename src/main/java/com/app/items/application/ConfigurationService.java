package com.app.items.application;

import com.app.items.domain.ports.ItemServicePort;
import com.app.items.domain.services.ItemService;
import com.app.items.infraestructure.adapter.ProductAdapterRest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationService {


    @Bean
    public ItemServicePort buildServiceItem(ProductAdapterRest productAdapterRest){
        return new ItemService(productAdapterRest);
    }
}
