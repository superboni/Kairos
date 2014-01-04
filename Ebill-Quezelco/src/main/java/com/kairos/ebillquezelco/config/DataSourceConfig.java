package com.kairos.ebillquezelco.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("default")
public class DataSourceConfig {

	@Value("${db.driverClassName}")
	private String driver;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;

	@Bean
    public DataSource dataSource() {
    	DriverManagerDataSource ds = new DriverManagerDataSource();
    	ds.setDriverClassName(driver);
    	ds.setUrl(url);
    	ds.setUsername(username);
    	ds.setPassword(password);
    	return ds;
    }
	
}
