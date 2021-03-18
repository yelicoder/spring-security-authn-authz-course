package com.pluralsight.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;

@Configuration
@Order(101)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				//.csrf().disable()
				//.csrf().disable()
				//.headers()
				// .cacheControl().disable()
				//.contentTypeOptions().disable()
				//.httpStrictTransportSecurity().disable()
				//.includeSubDomains(true).maxAgeInSeconds(31536000)
				//.frameOptions().sameOrigin().and()
				//.xssProtection().xssProtectionEnabled(false).and()
				//.contentSecurityPolicy().
				//.block(false).and()
				//.referrerPolicy(Re)
				//.featurePolicy("geolocation, 'self'")

				.authorizeRequests().anyRequest().authenticated().and().formLogin();
	}
	
}











//.cacheControl().disable()









//@Configuration
//@Order(2)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {		
//		http
//		.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//		.httpBasic().and().logout();
//	}
//	
//
//}
