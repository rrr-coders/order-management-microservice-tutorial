package io.rahul.inventory.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
