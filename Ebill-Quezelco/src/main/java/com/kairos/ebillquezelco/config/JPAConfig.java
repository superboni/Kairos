package com.kairos.ebillquezelco.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.kairos.ebillquezelco.domain")
public class JPAConfig {

    @Value("${db.driverClassName}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;
/*    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
*/
    @Bean
    public DataSource dataSourceConfig(){
    	DriverManagerDataSource ds = new DriverManagerDataSource();
    	ds.setDriverClassName(driver);
    	ds.setUrl(url);
    	ds.setUsername(username);
    	ds.setPassword(password);
    	return ds;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryConfig() {
    	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    	entityManagerFactoryBean.setDataSource(dataSourceConfig());
    	entityManagerFactoryBean.setPackagesToScan("com.kairos.ebillquezelco.domain");
    	entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    	
    	Properties jpaProperties = new Properties();
    	jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
    	//jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
    	entityManagerFactoryBean.setJpaProperties(jpaProperties);
    	
    	return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
    	return new JpaTransactionManager();
    }
    
    
}
