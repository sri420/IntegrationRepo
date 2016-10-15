package com.demo.composite.config;

import org.apache.camel.CamelContext;
import org.apache.camel.Processor;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.spi.InterceptStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomInterceptStrategy implements InterceptStrategy{
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomInterceptStrategy.class);
	@Override
	public Processor wrapProcessorInInterceptors(CamelContext context, ProcessorDefinition<?> definition,
			Processor target, Processor nextTarget) throws Exception {
		LOGGER.info("Inside interceptor logis");
		return null;
	}

}
