package com.pluralsight.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class
SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http
		.headers().cacheControl().disable().and()
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.httpBasic()
		.and()
		.formLogin();
	}
	
}
