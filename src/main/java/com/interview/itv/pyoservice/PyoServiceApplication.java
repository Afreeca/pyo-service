package com.interview.itv.pyoservice;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class PyoServiceApplication {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mm = new ModelMapper();
		mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // we need strict to only map to the fields we modify
		return mm;
	}

	public static void main(String[] args) {
		SpringApplication.run(PyoServiceApplication.class, args);
	}

}
