package com.kairos.ebillquezelco.config;

import javax.servlet.Filter;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(2)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer 
							implements ApplicationContextInitializer<AnnotationConfigWebApplicationContext>{

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {ApplicationConfig.class, JPAConfig.class, SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
    
    @Override
	public void initialize(AnnotationConfigWebApplicationContext context) {
		if (isCloudfoundry()) {
			ConfigurableEnvironment env = context.getEnvironment();
			env.addActiveProfile("cloud");
		}
	}
	
	private boolean isCloudfoundry() {
		return (System.getenv("VCAP_APPLICATION") != null);
	}

}
