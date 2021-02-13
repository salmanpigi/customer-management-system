package com.enigma.api.inventory.configs;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.models.response.CustomerResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(CustomerResponse.class, Customer.class).addMappings(mapper -> {
            mapper.skip(Customer::setId);
        });

        return modelMapper;
    }
}
