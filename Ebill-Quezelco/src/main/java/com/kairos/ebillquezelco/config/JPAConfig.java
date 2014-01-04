package com.kairos.ebillquezelco.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.kairos.ebillquezelco.domain")
public class JPAConfig {

	@Autowired
	private DataSource dataSource;
	
    @Value("${hibernate.dialect}")
    private String dialect;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryConfig() {
    	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    	entityManagerFactoryBean.setDataSource(dataSource);
    	entityManagerFactoryBean.setPackagesToScan("com.kairos.ebillquezelco.domain");
    	entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    	
    	Properties jpaProperties = new Properties();
    	jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
    	entityManagerFactoryBean.setJpaProperties(jpaProperties);
    	
    	return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
    	return new JpaTransactionManager();
    }
    
    
}
