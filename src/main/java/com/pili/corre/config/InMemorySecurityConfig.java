package com.pili.corre.config;

import static org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class InMemorySecurityConfig {

	 @Bean
	    public UserDetailsService userDetailsService() {

	        User.UserBuilder users = withDefaultPasswordEncoder();
	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        manager.createUser(users.username("pili").password("pili").roles("ADMIN").build());
	        return manager;

	    }
}
