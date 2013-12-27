package com.kairos.ebillquezelco.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
@ComponentScan("com.kairos.ebillquezelco")
public class ApplicationConfig {
	
	@Bean
	public static PropertyPlaceholderConfigurer persistencePropsPlaceholder() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("/persistence.properties"));
		return ppc;
	}
}
