package br.com.delogic.ticketExchange.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class ModelMapperConfig {
	
	/*
	   Configuration for automatic Mapping DTO <-> Entity
	*/
	@Bean
    public ModelMapper modelMapper() {
       return new ModelMapper();    
    }
}
