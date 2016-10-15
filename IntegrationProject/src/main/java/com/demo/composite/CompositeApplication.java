package com.demo.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class CompositeApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompositeApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Running CompositeApplication...");
		SpringApplication.run(CompositeApplication.class, args);
	}

}
