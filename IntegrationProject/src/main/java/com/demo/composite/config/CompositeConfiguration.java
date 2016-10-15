package com.demo.composite.config;

import javax.annotation.PostConstruct;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.demo.composite.client.bean.CompositeClientBean;

@Configuration
public class CompositeConfiguration {
	
	@Autowired
    CamelContext camelContext;

	@Component
	public class DefaultRouteBuilder extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);
		}
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(CompositeConfiguration.class);

	private static final String CAMEL_URL_MAPPING = "/camel/*";

	private static final String CAMEL_SERVLET_NAME = "CamelServlet";

	@Bean
	CompositeClientBean compositeClientBean() {
		LOGGER.info("Returning compositeClientBean...");
		return new CompositeClientBean();
	}

	@Bean
	CamelContextConfiguration contextConfiguration() {
		return new CamelContextConfiguration() {
			@Override
			public void afterApplicationStart(CamelContext context) {
				LOGGER.info("afterApplicationStart");
				//context.addInterceptStrategy(new CustomInterceptStrategy());
				//LOGGER.info("After Adding Custom Intercept Strategy");	
				
			}

			@Override
			public void beforeApplicationStart(CamelContext context) {
				LOGGER.info("beforeApplicationStart");
				

			}
		};
	}

	/*@PostConstruct
	public void addInterceptors(){
		LOGGER.info("****addInterceptors");
		camelContext.addInterceptStrategy(new CustomInterceptStrategy());
		LOGGER.info("****added interceptors");
		
	}*/
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		LOGGER.info("Registering Camel Servlet...");
		ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(),
				CAMEL_URL_MAPPING);
		registration.setName(CAMEL_SERVLET_NAME);
		LOGGER.info("Registered Camel Servlet.");
		return registration;
	}
}