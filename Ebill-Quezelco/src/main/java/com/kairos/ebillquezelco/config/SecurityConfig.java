package com.kairos.ebillquezelco.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final static String REMEMBER_ME_KEY = "remember-me-key";
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private MessageSource messageSource;
    
	@Bean
	public TokenBasedRememberMeServices rememberMeServices() {
		TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices(REMEMBER_ME_KEY, userDetailsService);
		rememberMeServices.setParameter("rememberMe");
		rememberMeServices.setCookieName("menggay");
		return rememberMeServices;
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetailsService);
		dao.setPasswordEncoder(passwordEncoder());
		dao.setMessageSource(messageSource);
		return dao;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.authenticationProvider(daoAuthenticationProvider())
			.eraseCredentials(true)
			.inMemoryAuthentication()
                .withUser("dandelion").password("raindrops").roles("ADMIN");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.csrf()
				.disable()
			.authorizeRequests()
				.antMatchers("/users/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
            .formLogin()
                .loginPage("/login")
                	.usernameParameter("secUsername")
                	.passwordParameter("secPassword")
                	.permitAll()
                	.and()
                .rememberMe()
	            	.rememberMeServices(rememberMeServices())
	            	.key(REMEMBER_ME_KEY)
	            	.and()
	            .logout()
		            .logoutUrl("/logout")
		            .deleteCookies("JSESSIONID")
		            .permitAll();
    }
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                .antMatchers("/resources/**");
    }
	
}
