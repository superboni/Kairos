package com.kairos.ebillquezelco.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "com.kairos.ebillquezelco", excludeFilters = @Filter(Controller.class))
public class ApplicationConfig {
	
	private static final String PERSISTENCE_PROPERTIES = "/persistence.properties";
	private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";

	@Bean
	public static PropertyPlaceholderConfigurer persistencePropsPlaceholder() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource(PERSISTENCE_PROPERTIES));
		return ppc;
	}
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(MESSAGE_SOURCE);
        messageSource.setCacheSeconds(5);
        return messageSource;
    }
	
}
